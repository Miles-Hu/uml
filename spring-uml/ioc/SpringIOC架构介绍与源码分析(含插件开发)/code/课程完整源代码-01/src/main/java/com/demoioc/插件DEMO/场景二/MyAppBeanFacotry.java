package com.demoioc.插件DEMO.场景二;

import com.demoioc.插件DEMO.场景二.bean.FunctionCentor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

@Log4j
public class MyAppBeanFacotry {
	public static void main(String[] args) {
//综合版本
		ApplicationContext cxac=new ClassPathXmlApplicationContext("com.demoioc.插件DEMO.场景二/applicationContextioc.xml");
		log.info("===========================================================");

		Map map=cxac.getBean(FunctionCentor.class).getFunctions();
		System.out.println(map);

//		a,c
//		b,c
	}
}
