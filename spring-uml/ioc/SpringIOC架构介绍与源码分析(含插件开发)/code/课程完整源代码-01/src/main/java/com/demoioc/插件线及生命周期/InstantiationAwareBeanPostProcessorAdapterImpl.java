package com.demoioc.插件线及生命周期;

import java.beans.PropertyDescriptor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class InstantiationAwareBeanPostProcessorAdapterImpl extends InstantiationAwareBeanPostProcessorAdapter {

    public InstantiationAwareBeanPostProcessorAdapterImpl() {
        super();
        //log.info("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    // 接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,  String beanName) throws BeansException {
        log.info("【容器级-InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation】beanName="+beanName);
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("【容器级-InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInitialization】beanName="+beanName);
        return bean;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,  PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        log.info("【容器级-InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues】beanName"+beanName);
        return pvs;
    }
}