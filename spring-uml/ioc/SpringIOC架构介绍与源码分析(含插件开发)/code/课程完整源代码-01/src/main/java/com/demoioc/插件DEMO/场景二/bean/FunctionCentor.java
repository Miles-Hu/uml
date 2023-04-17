package com.demoioc.插件DEMO.场景二.bean;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j
public class FunctionCentor implements BeanPostProcessor {
    public   Map<String, Object> functions = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        for (Method method:methods) {
//            log.info(method);
            Function function=method.getAnnotation(Function.class);
            if (function != null) {
                functions.put(function.value(),method);
            }
        }
        return bean;
    }

    public Map<String, Object> getFunctions() {
        return functions;
    }

    public void setFunctions(Map<String, Object> functions) {
        this.functions = functions;
    }
}
