package com.demoioc.使用方法.demo2;

import java.util.List;

import com.demoioc.使用方法.User;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;



/**
 * locations：可以通过该属性手工指定 Spring 配置文件所在的位置，
 * 可以指定一个或多个 Spring 配置文件
 * @author yangwang
 *
 */
@Log4j

@ContextConfiguration(locations = {"classpath:com.demoioc.使用方法.demo2/applicationContext-annotations.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

	/**
	 * @Autowired 注解让 Spring 容器自动注入 UserService 类型的 Bean
	 */
	@Autowired
	private UserService userService;

	/**
	 * @Test 注解则让 searchAll() 方法成为一个 JUnit 4.4 标准的测试方法
	 */
	@Test
	public void searchAll() {
		List<User> users = userService.searchAll();

		for (User user : users) {
			log.info(user.toString());
		}

	}

}
