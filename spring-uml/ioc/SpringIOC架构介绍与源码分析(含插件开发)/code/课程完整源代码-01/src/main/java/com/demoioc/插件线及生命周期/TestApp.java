package com.demoioc.插件线及生命周期;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
@Log4j
public class TestApp{

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("com.demoioc.插件线及生命周期/applicationContextioc.xml");
        log.info("==》》》容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        log.info("==》》》从容器中取出BEAN："+person);
        
        log.info("==》》》现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}