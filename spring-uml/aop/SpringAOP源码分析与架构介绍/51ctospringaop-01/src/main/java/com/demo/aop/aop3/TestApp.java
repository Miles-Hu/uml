package com.demo.aop.aop3;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com.demo.aop.aop3/applicationContext-aop.xml");

//		System.out.println("BeanName为："+Arrays.toString(context.getBeanNamesForType(IMySrv.class)));
		
		IMySrv mySrv = (IMySrv) context.getBean("mySrv");
//		System.out.println("BeanIns："+mySrv);
		mySrv.go();
	}
}
