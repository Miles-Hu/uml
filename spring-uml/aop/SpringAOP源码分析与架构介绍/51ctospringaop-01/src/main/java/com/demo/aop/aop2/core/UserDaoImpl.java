package com.demo.aop.aop2.core;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class UserDaoImpl implements IUserDao {
	
	public List<User> searchAll(){
		log.info("searchAll");
		List<User> users = new ArrayList<User>();
		User user = new User("smith",22);
		users.add(user);
		user = new User("tom",26);
		users.add(user);
		return users;
	}

	@Override
	public List<User> searchAll2() {
		return null;
	}

}
