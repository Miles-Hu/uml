package com.demoioc.插件线及生命周期;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class BeanPostProcessorImpl implements BeanPostProcessor {

    public BeanPostProcessorImpl() {
        super();
//        log.info("这是BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("【容器级-BeanPostProcessor.postProcessAfterInitialization】对属性进行更改！beanName="+beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)  throws BeansException {
        log.info("【容器级-BeanPostProcessor.postProcessBeforeInitialization】对属性进行更改！beanName="+beanName);
        return bean;
    }
}