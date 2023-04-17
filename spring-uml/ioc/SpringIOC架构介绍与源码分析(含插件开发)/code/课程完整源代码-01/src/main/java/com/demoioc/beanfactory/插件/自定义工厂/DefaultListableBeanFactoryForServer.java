package com.demoioc.beanfactory.插件.自定义工厂;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class DefaultListableBeanFactoryForServer extends DefaultListableBeanFactory {

	public DefaultListableBeanFactoryForServer(BeanFactory parentBeanFactory) {
		super(parentBeanFactory);
	}

	@Override
	protected String transformedBeanName(String name) {
		if (name.contains("flowRobDao4judge")) {

			return "flowRobDao4ONE";
		}
		return super.transformedBeanName(ServerUtil.getInvokeBeanName(name));
	}

}
