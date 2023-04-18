package com.demo.aop.aop2;

import lombok.extern.log4j.Log4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Log4j
public class MyAdvice4Dao implements MethodInterceptor{


	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("invoke");
		Object tmp=invocation.proceed();
		return tmp;
	}

} 
