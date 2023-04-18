package com.demo.db.transaction.demo;

public  class Person {

	private int id;
	private User user;

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

//	public User getUser() {
//		return this.user;
//	}
	public  User getUser(){
		return null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
