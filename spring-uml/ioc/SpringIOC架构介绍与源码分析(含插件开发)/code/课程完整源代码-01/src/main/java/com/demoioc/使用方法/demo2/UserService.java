package com.demoioc.使用方法.demo2;

import java.util.List;

import com.demoioc.使用方法.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class UserService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	public List<User> searchAll(){
		return userDao.searchAll();
	}

}
