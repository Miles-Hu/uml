package com.demoioc.beanfactory.postprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
@Log4j
public class MyApp {

	/**
	 */
	public static void main(String[] args) {
		ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("com.demoioc.beanfactory.postprocessor/application.xml"));
		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) beanFactory.getBean("bfpp");
		bfpp.postProcessBeanFactory(beanFactory);

		SimpleBean simpleBean = (SimpleBean) beanFactory.getBean("simpleBean");
		log.info("创建后的对象为："+simpleBean);
		log.info("被过滤前的文字："+beanFactory.getBean("obscenitiesRemoved"));

	}

}
