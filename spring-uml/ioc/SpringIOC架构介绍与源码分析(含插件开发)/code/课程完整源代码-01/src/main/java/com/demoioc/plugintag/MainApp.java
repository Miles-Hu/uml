package com.demoioc.plugintag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//http://blog.csdn.net/cutesource/article/details/5864562
public class 	MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com.demoioc.plugintag/applicationContext.xml");
		People p = (People) ctx.getBean("cutesource");
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}
}
