package com.demoioc.插件DEMO.场景一.bean.plugins;

import com.demoioc.插件DEMO.场景一.bean.app.AbsOldBean;
import com.demoioc.插件DEMO.场景一.bean.app.OldBean;
import com.demoioc.插件DEMO.场景一.bean.validate.ValidateService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class BeanPostProcessor4AutoInject implements BeanPostProcessor, BeanFactoryAware {
	private BeanFactory beanFactory;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AbsOldBean) {// 这里必须用irest而不能用defaultrest因为有很多走了日志AOP（JDK动态代理）
			OldBean oldBean=	(OldBean) bean;
			if (oldBean.getValidateService()!=null){
				return bean;// 已经注入了则不处理，场景：在REST成员上已经加了resource或springxml中已经配置了property
			}
			try {
				String beanNameTarget=beanName+"Validate";
				Object targetTmp = beanFactory.getBean(beanNameTarget);//beanname可能是chg4ProxyClass
				if (targetTmp instanceof ValidateService) {
					oldBean.setValidateService((ValidateService) targetTmp);
					log.info("【BEAN成员自动注入框架】成功:rest类:" + beanName +", 成员Validate:" + targetTmp);
				}
			} catch (NoSuchBeanDefinitionException e) {
			}

		}
		return bean;
	}

	private String chg4ProxyClass(String simpleName, ValidateService targetRest, String beanName, FlagValue flagValue) {
		// 可能是动态代理类:$Proxy35,可以调用toString()返回:DelMemRest()或DefaultRest(validateService=null
		if (simpleName.contains("$Proxy")) {
			String jdkClassName = targetRest.toString();
			if (jdkClassName.contains("(")) {
				simpleName = jdkClassName.substring(0, jdkClassName.indexOf("("));
				if (simpleName.contains("DefaultRest")) {
					simpleName = beanName;// 如果是 Rest代理，则使用原始的BEAN_NAME
					flagValue.setDesc("(由动态代理=> Rest转换)");
				} else {
					flagValue.setDesc("(由动态代理转换)");
				}
				log.debug("【BEAN成员自动注入框架】从代理类中还原出:" + simpleName);
			}
		} else {
			flagValue.setDesc("(原生)");
		}
		return simpleName;
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	class FlagValue {
		@Getter
		@Setter
		String desc;
	}

}
