package com.demoioc.使用方法.demo2;

import java.util.ArrayList;
import java.util.List;

import com.demoioc.使用方法.User;
import org.springframework.stereotype.Repository;


/**
 * 从Spring 2.0开始,引入了@Repository注解,用它来标记充当储存库(又称 Data Access Object或DAO)角色或典型的类。
 * Spring 2.5引入了更多典型化注解(stereotype annotations)： 
 * 		@Component、@Service和 @Controller。 
 * 	@Component是所有受Spring管理组件的通用形式； 
 * 	而@Repository、@Service和 @Controller则是@Component的细化， 用来表示更具体的用例(例如，分别对应了持久化层、服务层和表现层)。
 *
 */
@Repository("userDao")
public class UserDao {
	
	public List<User> searchAll(){
		List<User> users = new ArrayList<User>();
		User user = new User("smith",22);
		users.add(user);
		user = new User("tom",26);
		users.add(user);
		return users;
	}

}
