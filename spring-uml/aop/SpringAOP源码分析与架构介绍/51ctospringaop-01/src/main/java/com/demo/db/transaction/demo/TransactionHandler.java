package com.demo.db.transaction.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {

	private Object target;

	public TransactionHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		TransactionManager.beginTransaction(method.getName());
		
		if(args == null){
			System.out.println("null");
		}
		
		Object obj = method.invoke(target, args);
		
		TransactionManager.endTransaction(method.getName());
		return obj;
	}

}
