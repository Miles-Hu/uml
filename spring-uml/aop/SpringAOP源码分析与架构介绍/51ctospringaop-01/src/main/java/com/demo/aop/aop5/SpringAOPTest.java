package com.demo.aop.aop5;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com.demo.aop.aop5/applicationContext-aop.xml");
		PersonService bean = (PersonService)ctx.getBean("personServiceImpl");
		bean.save("21");
	}
	

}