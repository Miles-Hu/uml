package com.demo.db.datasource.multdatasource.demo3;

import com.demo.db.datasource.multdatasource.demo1.CustomerContextHolder;
import lombok.extern.log4j.Log4j;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.Ordered;

@Log4j
public class MyAdvice4ChgDatasource implements MethodInterceptor,Ordered {

	public Object invoke(MethodInvocation invocation) throws Throwable {

//		log.info("拦截值为："+invocation.getArguments()[0]);
		if (Integer.valueOf("" + invocation.getArguments()[0]).intValue() == 1) {
			CustomerContextHolder.setCustomerType("MASTER");
		} else {
			CustomerContextHolder.setCustomerType("SLAVE");
		}

		Object tmp = invocation.proceed();
		
		
		return tmp;
	}

	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

}
