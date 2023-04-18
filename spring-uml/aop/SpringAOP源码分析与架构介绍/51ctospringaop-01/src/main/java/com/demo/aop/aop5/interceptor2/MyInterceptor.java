package com.demo.aop.aop5.interceptor2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Service("my2")
public class MyInterceptor implements Ordered{
	@Pointcut("@annotation(com.demo.aop.aop5.interceptor2.MyAnnotation)")
	private void anyMethod() {
	}// 定义一个切入点

	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		log.info("MyInterceptor2----before");
		Object object = pjp.proceed();// 执行该方法
		log.info("MyInterceptor2----after");
		return object;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}