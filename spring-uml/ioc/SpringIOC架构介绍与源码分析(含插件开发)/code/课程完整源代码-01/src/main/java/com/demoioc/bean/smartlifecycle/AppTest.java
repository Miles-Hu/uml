package com.demoioc.bean.smartlifecycle;


import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class AppTest {
	private static ApplicationContext ac=
			new ClassPathXmlApplicationContext("com.demoioc.bean.smartlifecycle/applicationContext.xml");

	public static void main(String[] args) {
		try {
			log.info(ac.getBean(MyLifecycle.class));
//			Thread.sleep(100000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
