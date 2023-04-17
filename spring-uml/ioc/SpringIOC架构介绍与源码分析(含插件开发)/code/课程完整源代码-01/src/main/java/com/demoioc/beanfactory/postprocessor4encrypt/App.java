package com.demoioc.beanfactory.postprocessor4encrypt;

import com.demoioc.beanfactory.postprocessor.SimpleBean;
import lombok.extern.log4j.Log4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class App {

	/**
	 * TODO
	 * 
	 * @author 王陶林
	 * @date 2014-8-6 上午7:20:58
	 * @version: V1.0
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 这种写法是不会触发属性文件替换的哦
		// ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
		// new  ClassPathResource("com/demoioc/beanfactory/postprocessor/application.xml"));
		//这种写法可以
		ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext(
				"com.demoioc.beanfactory.postprocessor4encrypt/application.xml");
		log.info("==》》" + beanFactory.getBean("aa"));
		SimpleBean simpleBean = (SimpleBean) beanFactory.getBean("bb");
		log.info("创建后的对象为：" + simpleBean);
	}

}
