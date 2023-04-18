package com.demo.aop.aop2.core;

public class User {
	
	private int id;
	private String username;

	public User(String username,int id ) {
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
