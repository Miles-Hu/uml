package com.demo.aop.aop1;

import java.lang.reflect.Method;

import lombok.extern.log4j.Log4j;
import org.springframework.aop.AfterReturningAdvice;

@Log4j
public class AfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info("afterReturning£¬returnValue="+returnValue+"=="+method);
    }

} 

