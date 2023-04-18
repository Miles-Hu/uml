package com.demo.aop.aop4;

import java.util.Arrays;

import com.demo.aop.aop4.srv.IMySrv;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Log4j
public class TestApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com.demo.aop.aop4/applicationContext-aop.xml");

//		System.out.println("BeanName为："+Arrays.toString(context.getBeanNamesForType(IMySrv.class)));
		
		IMySrv mySrv = (IMySrv) context.getBean("mySrv");
//		System.out.println("BeanIns："+mySrv);
		log.info("aa==>>"+mySrv.go());
	}
}
