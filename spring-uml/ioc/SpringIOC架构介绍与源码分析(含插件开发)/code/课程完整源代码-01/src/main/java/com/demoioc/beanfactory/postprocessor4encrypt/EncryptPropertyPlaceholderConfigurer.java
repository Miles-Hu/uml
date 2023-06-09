package com.demoioc.beanfactory.postprocessor4encrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Log4j
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private static final String SEC_KEY = "@^_^aBcZ*"; // 主密钥
	private static final String ENCRYPTED_PREFIX = "Encrypted:{";
	private static final String ENCRYPTED_SUFFIX = "}";
	private static Pattern encryptedPattern = Pattern.compile("Encrypted:\\{((\\w|\\-)*)\\}"); // 加密属性特征正则

	private Set<String> encryptedProps = Collections.emptySet();

	public void setEncryptedProps(Set<String> encryptedProps) {
		this.encryptedProps = encryptedProps;
	}

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {

		if (encryptedProps.contains(propertyName)) { // 如果在加密属性名单中发现该属性
			final Matcher matcher = encryptedPattern.matcher(propertyValue); // 判断该属性是否已经加密
			if (matcher.matches()) { // 已经加密，进行解密
				String encryptedString = matcher.group(); // 获得加密值
				String decryptedPropValue = AesUtils.decrypt(propertyName + SEC_KEY, encryptedString); // 调用AES进行解密，SEC_KEY与属性名联合做密钥更安全

				if (decryptedPropValue != null) { // !=null说明正常
					propertyValue = decryptedPropValue; // 设置解决后的值
				} else {// 说明解密失败
					log.error("Decrypt " + propertyName + "=" + propertyValue + " error!");
				}
			}
		}

		return super.convertProperty(propertyName, propertyValue); // 将处理过的值传给父类继续处理
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		super.postProcessBeanFactory(beanFactory); // 正常执行属性文件加载

		for (Resource location : locations) { // 加载完后，遍历location，对properties进行加密
			try {
				final File file = location.getFile();
				if (file.isFile()) { // 如果是一个普通文件
					if (file.canWrite()) { // 如果有写权限
						encrypt(file); // 调用文件加密方法
					} else {
						log.warn("File '" + location + "' can not be write!");
					}
				} else {
					log.warn("File '" + location + "' is not a normal file!");
				}
			} catch (IOException e) {
				log.warn("File '" + location + "' is not a normal file!");
			}
		}

	}

	/**
	 * 属性文件加密方法
	 * 
	 * @param file
	 */
	private void encrypt(File file) {

		List<String> outputLine = new ArrayList<String>(); // 定义输出行缓存

		boolean doEncrypt = false; // 是否加密属性文件标识

		BufferedReader bufferedReader = null;
		try {

			bufferedReader = new BufferedReader(new FileReader(file));

			String line = null;
			do {

				line = bufferedReader.readLine(); // 按行读取属性文件
				if (line != null) { // 判断是否文件结束
					if (!StringUtils.isBlank(line)) { // 是否为空行
						line = line.trim(); // 取掉左右空格
						if (!line.startsWith("#")) {// 如果是非注释行
							String[] lineParts = line.split("="); // 将属性名与值分离
							String key = lineParts[0]; // 属性名
							String value = lineParts[1]; // 属性值
							if (key != null && value != null) {
								if (encryptedProps.contains(key)) { // 发现是加密属性
									final Matcher matcher = encryptedPattern.matcher(value);
									if (!matcher.matches()) { // 如果是非加密格式，则`进行加密
										value = ENCRYPTED_PREFIX + AesUtils.encrypt(key + SEC_KEY, value) + ENCRYPTED_SUFFIX; // 进行加密，SEC_KEY与属性名联合做密钥更安全
										line = key + "=" + value; // 生成新一行的加密串
										doEncrypt = true; // 设置加密属性文件标识
										log.debug("encrypt property:" + key);
									}
								}
							}
						}
					}
					outputLine.add(line);
				}

			} while (line != null);

		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}

		if (doEncrypt) { // 判断属性文件加密标识
			BufferedWriter bufferedWriter = null;
			File tmpFile = null;
			try {
				tmpFile = File.createTempFile(file.getName(), null, file.getParentFile()); // 创建临时文件
				if (log.isDebugEnabled()) {
					log.debug("Create tmp file '" + tmpFile.getAbsolutePath() + "'.");
				}
				bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
				final Iterator<String> iterator = outputLine.iterator();
				while (iterator.hasNext()) { // 将加密后内容写入临时文件
					bufferedWriter.write(iterator.next());
					if (iterator.hasNext()) {
						bufferedWriter.newLine();
					}
				}
				bufferedWriter.flush();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			} finally {
				if (bufferedWriter != null) {
					try {
						bufferedWriter.close();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			}

			File backupFile = new File(file.getAbsoluteFile() + "_" + System.currentTimeMillis()); // 准备备份文件名
			// 以下为备份，异常恢复机制
			if (!file.renameTo(backupFile)) { // 重命名原properties文件，（备份）
				log.error("Could not encrypt the file '" + file.getAbsoluteFile() + "'! Backup the file failed!");
				tmpFile.delete(); // 删除临时文件
			} else {
				if (log.isDebugEnabled()) {
					log.debug("Backup the file '" + backupFile.getAbsolutePath() + "'.");
				}

				if (!tmpFile.renameTo(file)) { // 临时文件重命名失败 （加密文件替换原失败）
					log.error("Could not encrypt the file '" + file.getAbsoluteFile() + "'! Rename the tmp file failed!");

					if (backupFile.renameTo(file)) { // 恢复备份
						if (log.isInfoEnabled()) {
							log.info("Restore the backup, success.");
						}
					} else {
						log.error("Restore the backup, failed!");
					}
				} else { // （加密文件替换原成功）

					if (log.isDebugEnabled()) {
						log.debug("Rename the file '" + tmpFile.getAbsolutePath() + "' -> '" + file.getAbsoluteFile() + "'.");
					}

					boolean dBackup = backupFile.delete();// 删除备份文件

					if (log.isDebugEnabled()) {
						log.debug("Delete the backup '" + backupFile.getAbsolutePath() + "'.(" + dBackup + ")");
					}
				}
			}

		}

	}

	protected Resource[] locations;

	@Override
	public void setLocations(Resource[] locations) { // 由于location是父类私有，所以需要记录到本类的locations中
		super.setLocations(locations);
		this.locations = locations;
	}

	@Override
	public void setLocation(Resource location) { // 由于location是父类私有，所以需要记录到本类的locations中
		super.setLocation(location);
		this.locations = new Resource[] { location };
	}
}