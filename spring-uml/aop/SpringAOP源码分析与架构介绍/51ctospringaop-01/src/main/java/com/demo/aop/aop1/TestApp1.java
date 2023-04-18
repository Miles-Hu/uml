package com.demo.aop.aop1;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

import com.demo.aop.aop1.AfterAdvice;
import com.demo.aop.aop1.BeforeAdvice;
import com.demo.aop.aop1.IDinner;
import com.demo.aop.aop1.ImplDinner;

/**
 */
public class TestApp1 {
	public static void main(String[] args) {
		IDinner target=new ImplDinner();
		ProxyFactory proxyFactory=new ProxyFactory(target);

		RegexpMethodPointcutAdvisor badvisor=new RegexpMethodPointcutAdvisor();
		badvisor.setAdvice(new BeforeAdvice());
		badvisor.setPattern(".*IDinner.*method*.*");
		proxyFactory.addAdvisor(badvisor);

		RegexpMethodPointcutAdvisor aadvisor=new RegexpMethodPointcutAdvisor();
		aadvisor.setAdvice(new AfterAdvice());
		aadvisor.setPattern(".*.*");
		proxyFactory.addAdvisor(aadvisor);


		IDinner iStudent=(IDinner)proxyFactory.getProxy();
		iStudent.method1("p1");
		System.out.println("----------------------------");
		iStudent.method2("p2");
	}
}
