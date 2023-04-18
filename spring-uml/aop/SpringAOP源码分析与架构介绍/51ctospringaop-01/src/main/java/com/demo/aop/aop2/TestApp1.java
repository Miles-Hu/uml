package com.demo.aop.aop2;

import com.demo.aop.aop2.core.UserService;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestApp1 extends TestCase {

    ApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("com.demo.aop.aop2/applicationContext-aop.xml");
    }

    public void testSearchAll() {
        UserService userService = (UserService) context.getBean("userService");
        userService.searchAll();
    }

}
