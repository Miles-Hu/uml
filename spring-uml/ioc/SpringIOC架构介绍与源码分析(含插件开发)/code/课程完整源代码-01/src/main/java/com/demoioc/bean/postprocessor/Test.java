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
 * ����ʱ�䣺2012-2-24 ����06:37:29 
 * ��˵�� 
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
//		log.info("���ȣ�"+ss.length);
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
//		Environment environment = new Environment() ;// ����һ���������� 
//        environment.setProviderurl("t3://www.blogjava.net") ; 
//        environment.setSecurityPrincipal("todd") ;// ��֤���û��� 
//        environment.setSecurityCredentials("841026") ;// ���� 
//        Context context = environment.getInitialContext() ; 
//// ����һ�� subContext ����һ������ 
//        Context subContext = context.createSubcontext("subContext") ; 
//        subContext.rebind("newObject",object) ;// �󶨵Ķ�������ǿ����л��� 
//        subContext.close() ; 
//        context.close() ; 
//		
//	}
}
