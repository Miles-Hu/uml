package com.demo.db.transaction.demo;

import java.lang.reflect.Proxy;

public class TestJDKDynamicProxy {

	public static void main(String[] args) {
		UserServiceImpl target = new UserServiceImpl();
		TransactionHandler handler = new TransactionHandler(target);
		
		UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target
				.getClass().getInterfaces(), handler);
		
		proxy.save(1, "smith");
		proxy.find(1);
	}
}
