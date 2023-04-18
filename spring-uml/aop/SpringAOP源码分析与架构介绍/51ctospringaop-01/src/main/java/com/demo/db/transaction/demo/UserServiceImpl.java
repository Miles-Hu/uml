package com.demo.db.transaction.demo;

public class UserServiceImpl implements UserService {

	public void save(int id, String username) {
		System.out.println(id + " : " + username);
	}
	
	public void find(int i){
		System.out.println("hello world");
	}
}
