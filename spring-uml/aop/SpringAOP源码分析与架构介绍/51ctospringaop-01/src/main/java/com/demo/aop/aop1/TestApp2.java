package com.demo.aop.aop1;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp2 {

    @Test
    public void testStudent() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com.demo.aop.aop1/applicationContext-aop.xml");
        IDinner iStudent = (IDinner) ctx.getBean("dinner");


//        System.out.println(Arrays.toString(iStudent.getClass().getMethods()));
        iStudent.method1("method-1--param");
        System.out.println("----------------------------");
        iStudent.method2("method-2--param");


    }

}
