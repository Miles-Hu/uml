package com.demoioc.使用方法.demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.demoioc.使用方法.User;
import lombok.Data;

import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
@Data
@Log4j
public class Company {

	private String name;
	private List<User> users;
	@Resource
	private User user;

	public String getName() {
		return name;
	}

	@PostConstruct
	public void myInit(){
		log.info("hahaha   ");
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
