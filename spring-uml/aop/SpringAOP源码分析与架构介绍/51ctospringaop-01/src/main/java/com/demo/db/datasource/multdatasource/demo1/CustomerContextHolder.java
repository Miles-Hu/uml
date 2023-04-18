package com.demo.db.datasource.multdatasource.demo1;

import org.springframework.util.Assert;

public class CustomerContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		Assert.notNull(customerType, "customerType cannot be null");
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return (String) contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
