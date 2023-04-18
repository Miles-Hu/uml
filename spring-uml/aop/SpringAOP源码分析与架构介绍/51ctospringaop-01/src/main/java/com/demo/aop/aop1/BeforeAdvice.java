package com.demo.aop.aop1;

import java.lang.reflect.Method;

import lombok.extern.log4j.Log4j;
import org.springframework.aop.MethodBeforeAdvice;

/** 
 */
@Log4j
public class BeforeAdvice implements MethodBeforeAdvice{ 

	public void before(Method method, Object[] objects, Object o) throws Throwable {
		log.info("before");
	}
} 

