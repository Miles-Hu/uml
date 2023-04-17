package com.demoioc.使用方法;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@NoArgsConstructor
@Log4j
public class User {

	private String username;
	private int age;

	public User(String username, int age) {
//		log.info("调用User的构造方法！");
		this.username = username;
		this.age = age;
	}
	public void initUser(){
		log.info("初始化User哈");
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
