package com.demo.aop.aop1;


import lombok.extern.log4j.Log4j;

@Log4j
public class ImplDinner implements IDinner {

	public void method1(String name) {
		log.info("method1");
	}

	public void method2(String name) {
		log.info("method2");
	}

}

