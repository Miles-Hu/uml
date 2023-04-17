package com.demoioc.beanfactory.postprocessor;

import lombok.Data;

@Data
public class SimpleBean {
	private String connectionString;
	private String password;
	private String username;
}
