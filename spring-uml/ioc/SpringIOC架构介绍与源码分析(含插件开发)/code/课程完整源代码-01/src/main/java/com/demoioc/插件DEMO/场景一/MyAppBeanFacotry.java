package com.demoioc.插件DEMO.场景一;

import com.demoioc.bean.postprocessor.MyTestCar;
import com.demoioc.插件DEMO.场景一.bean.app.OldBean;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class MyAppBeanFacotry {
	public static void main(String[] args) {
//综合版本
		ApplicationContext cxac=new ClassPathXmlApplicationContext("com.demoioc.插件DEMO.场景一/applicationContextioc.xml");
		log.info("===========================================================");

				log.info(cxac.getBean(OldBean.class).getValidateService());
	}
}
