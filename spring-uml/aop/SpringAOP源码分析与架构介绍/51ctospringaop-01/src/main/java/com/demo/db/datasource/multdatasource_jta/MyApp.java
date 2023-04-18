package multdatasource_jta;

import multdatasource_jta.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("multdatasource_jta/ApplicationContext.xml");
		UserService us = (UserService) cxt.getBean("userService");
		us.saveUser("1", "test2");
	}
}
