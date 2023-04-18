package com.demo.db.transaction.demo;

public class TransactionManager {
	public static void beginTransaction(String methodName) {
		System.out.println(methodName + "开始事务管理!");
	}

	public static void endTransaction(String methodName) {
		System.out.println(methodName + "事务管理结束!\n");
	}
}