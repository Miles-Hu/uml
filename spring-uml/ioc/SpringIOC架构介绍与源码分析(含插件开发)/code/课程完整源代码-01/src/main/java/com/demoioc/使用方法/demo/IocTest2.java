package com.demoioc.使用方法.demo;

import java.lang.reflect.Constructor;

import com.demoioc.使用方法.User;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j;

@Log4j
public class IocTest2 extends TestCase {

	String className = "com.demoioc.demo.User";

	@SuppressWarnings("unchecked")
	public void testIoc() throws Exception {
		Constructor<User> c = (Constructor<User>) Class.forName(className).getConstructor(String.class,int.class);
		User u = c.newInstance("hello",1);
		log.info(u.toString());
	}

}
