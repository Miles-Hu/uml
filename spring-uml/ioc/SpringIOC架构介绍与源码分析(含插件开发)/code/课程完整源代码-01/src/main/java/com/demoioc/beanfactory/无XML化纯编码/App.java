package com.demoioc.beanfactory.无XML化纯编码;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;


//无XML化纯编码
@Log4j
public class App {
	public static void main(String[] args) {
		ConfigurableListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		beanFactory.registerSingleton("myTest", "我的测试");
		log.info("测试：" + beanFactory.getBean("myTest"));
		
		beanFactory.registerSingleton("myTest2", new User("11","22"));
		log.info("测试：" + beanFactory.getBean("myTest2"));
		
		;
		log.info(Arrays.toString(beanFactory.getBeanDefinitionNames()));
		
		log.info(beanFactory.isSingleton("myTest2"));
	}
	@Data
	@AllArgsConstructor
	static class User{
		private String name;
		private String sex;
	}
}
