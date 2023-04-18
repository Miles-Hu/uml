package com.demo.aop.aop2.core;

import java.util.List;


public class UserService {

	private IUserDao userDao;
	
	public List<User> searchAll(){
		return userDao.searchAll();
	}
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
