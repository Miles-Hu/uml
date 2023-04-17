package com.demoioc.使用方法.demo;

import com.demoioc.使用方法.UserMap;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;
@Log4j
public class IocTest extends TestCase {

    ApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext-ioc.xml");
    }

    /**
     * 1锟斤拷锟斤拷锟届函锟斤拷注锟斤拷
     */
    public void testIocByConstructor() {
        context.getBean("user3");

    }

    /**
     * 2锟斤拷setter注锟诫： 2.1 list
     */
    public void testIocBySetterList() {
        Company company = (Company) context.getBean("company");
        log.info(company.toString());
    }

    /**
     * 2.2 set
     */
    public void testIocBySetterSet() {
        Department department = (Department) context.getBean("department");
        log.info(department.toString());
    }

    /**
     * 2.3 properties
     */
    public void testIocByProperties() {
        Properties properties = (Properties) context.getBean("properties");
        log.info(properties.getProperty("1"));
        log.info(properties.getProperty("2"));
    }

    /**
     * 2.4 map
     */
    public void testIocBySetterMap() {
        UserMap userMap = (UserMap) context.getBean("userMap");
        log.info(userMap.toString());
    }

}
