package com.demoioc.bean.postprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.util.Arrays;




/** 
 * @author wangtl
 * 创建时间：2012-2-24 上午06:37:29 
 * 类说明 
 */
@Log4j
public class Test {
	static {
//		log.info("ddd");
	}
	public static void main(String[] args) {
		ClassPathResource res=new ClassPathResource("applicationContext-common.xml");
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);
		log.info(factory.getBean("mySessionFactory"));
		
//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//		log.info(factory.getBean("company"));
		
		
		ClassPathXmlApplicationContext cxac=new ClassPathXmlApplicationContext("classpath*:com/demoioc/bean/postprocessor/applicationContext-ioc.xml");
//		String[] ss=cxac.getBeanDefinitionNames();
//		log.info("长度："+ss.length);
//		for (int i = 0; i < ss.length; i++) {
//			log.info(ss[i]);
//		}
		MyTestCar car=(MyTestCar)cxac.getBean("car");
		log.info(car);
//		log.info(cxac.getBean("&company"));
//		ApplicationContext ac= new FileSystemXmlApplicationContext("config/applicationContext-common.xml");
//		log.info(ac.getBean("mySessionFactory"));
//		jndiTest();
//		List list = new ArrayList();
//		long i = 0;
//		String a;
//		while (true) {
//			list.add(String.valueOf(i++).intern());
//			a=""+i++;
//			log.info(a);
//		}
		String CONFIG_LOCATION_DELIMITERS = ",; \t\n";
		String[] a= StringUtils.tokenizeToStringArray("classpath:applicationContext*.xml,classpath:*/applicationContext*.xml", CONFIG_LOCATION_DELIMITERS);
		log.info(Arrays.toString(a));
		
		
	}

	/**
	 * 
	 */
//	private static void jndiTest() {
//		Environment environment = new Environment() ;// 创建一个环境对象 
//        environment.setProviderurl("t3://www.blogjava.net") ; 
//        environment.setSecurityPrincipal("todd") ;// 认证的用户名 
//        environment.setSecurityCredentials("841026") ;// 密码 
//        Context context = environment.getInitialContext() ; 
//// 创建一个 subContext 并绑定一个对象： 
//        Context subContext = context.createSubcontext("subContext") ; 
//        subContext.rebind("newObject",object) ;// 绑定的对象必须是可序列化的 
//        subContext.close() ; 
//        context.close() ; 
//		
//	}
}
