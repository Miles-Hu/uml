package com.demoioc.beanfactory.插件.自定义工厂;


public class ServerUtil {


	/**
	 * 得到需要执行的bean
	 * 
	 */
	public static String getInvokeBeanName(String bean) {
		if (bean.contains("flowRobDao4judge")) {
			
			return "flowRobDao4ONE";
		}
		return bean;
	}

}
