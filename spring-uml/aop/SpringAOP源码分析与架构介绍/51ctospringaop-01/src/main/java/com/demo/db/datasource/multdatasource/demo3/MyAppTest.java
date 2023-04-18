package com.demo.db.datasource.multdatasource.demo3;

import lombok.extern.log4j.Log4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangtl 创建时间：2012-5-30 下午10:04:31 类说明
 */
@Log4j
public class MyAppTest extends Thread {
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("multdatasource/demo3/applicationContext-main.xml",
			"multdatasource/demo3/applicationContext-datasource.xml");

	int src=0;
	public MyAppTest(int src) {
		this.src=src;
	}

	public static void main(String[] args) throws Exception {
		new MyAppTest(1).start();
		new MyAppTest(2).start();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				SysAdminServiceImpl sysAdminService1 = (SysAdminServiceImpl) ac.getBean("sysAdminService");
				
				log.info("=>线程"+Thread.currentThread().getId()+",输入："+src+",结果为：" + sysAdminService1.queryUserList1(src));
				
				Thread.sleep(100);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
