package com.demoioc.beanfactory.postprocessor;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * 删除非法字符
 * 
 * @author partner4java
 * 
 */
@Log4j
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor, BeanNameAware {
	/** bean的名称 */
	private String name;
	/** 注册过滤文字 */
	private Set<String> obscenities;
	/** 返回过滤掉的文字 */
	private Set<String> obscenitiesRemoved;

	public ObscenityRemovingBeanFactoryPostProcessor() {
		this.obscenities = new HashSet<String>();
		this.obscenitiesRemoved = new HashSet<String>();
	}

	/**
	 * 主要业务处理。
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();

		// 下面两个类是用来替换参数的
		// Simple strategy interface for resolving a String value.
		StringValueResolver valueResolver = new StringValueResolver() {
			public String resolveStringValue(String strVal) {
				if (isObscene(strVal)) {
					obscenitiesRemoved.add(strVal);
					return "****";
				}
				return strVal;
			}
		};
		// Visitor class for traversing BeanDefinition objects, in particular
		// the property values and constructor argument values contained in
		// them, resolving bean metadata values.
		// Used by PropertyPlaceholderConfigurer to parse all String values
		// contained in a BeanDefinition, resolving any placeholders found.
		BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);

		for (String beanName : beanNames) {
			if (beanName.equals(this.name))
				continue;

			// 如果不是实体就应该是参数，获取参数
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

			visitor.visitBeanDefinition(beanDefinition);
		}
		beanFactory.registerSingleton("obscenitiesRemoved", this.obscenitiesRemoved);
	}

	private boolean isObscene(Object value) {
		String potentialObscenity = value.toString().toUpperCase();
		return this.obscenities.contains(potentialObscenity);
	}

	public void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
		for (String obscentity : obscenities) {
			this.obscenities.add(obscentity.toUpperCase());
		}
	}

	public void setBeanName(String name) {
		this.name = name;
		log.info("传入的BEAN_NAME为："+name);
	}

}
