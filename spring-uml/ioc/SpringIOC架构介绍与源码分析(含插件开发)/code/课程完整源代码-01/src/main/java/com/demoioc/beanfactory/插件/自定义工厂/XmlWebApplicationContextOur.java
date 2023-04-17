package com.demoioc.beanfactory.插件.自定义工厂;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.context.support.XmlWebApplicationContext;

//重写BEAN工厂，接入我们的自己的BEAN工厂
public class XmlWebApplicationContextOur extends XmlWebApplicationContext {
	protected DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactoryForServer(getInternalParentBeanFactory());
	}
}
