package com.demoioc.bean.postprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/** 
 * @author wangtl
 * ����ʱ�䣺2012-5-27 ����05:19:28 
 * ��˵�� 
 */
@Log4j
public class MyTestBeanFactoryPostProcessor implements BeanPostProcessor{

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info(">>>>>>postProcessAfterInitialization========="+beanName);
		return bean;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info(">>>>>>postProcessBeforeInitialization========="+beanName);
		return bean;
	}

}
