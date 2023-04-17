package com.demoioc.beanfactory;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.demoioc.bean.postprocessor.MyTestCar;
@Log4j
public class MyAppBeanFacotry {
   //这种方法无法走配置文件，因为非AbstractXmlApplicationContext流程，只能走基础的BEAN工厂

	public static void main(String[] args) {
//基础版本：
//		将配置文件转换为Resource，
//		利用BeanDefinitionReader将Resource里定义的bean对象解析成BeanDefinition，
//		将BeanDefinition注册到BeanFactory，BeanFactory里将会维护一个BeanDefinition的Map。
		Resource resource=new ClassPathResource("com.demoioc.beanfactory/applicationContextioc.xml");
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		log.info(factory.getBean("car"));

//简化版本，将读取器内聚进XmlBeanFactory里面
		Resource res = new ClassPathResource("com.demoioc.beanfactory/applicationContextioc.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		MyTestCar car=(MyTestCar)bf.getBean("car");
		log.info(car);

		log.info("===========================================================");
//综合版本
		ApplicationContext cxac=new ClassPathXmlApplicationContext("com.demoioc.beanfactory/applicationContextioc.xml");
		MyTestCar car2=(MyTestCar)cxac.getBean("car");
		log.info(car2);
		log.info("===========================================================");
	}
}
