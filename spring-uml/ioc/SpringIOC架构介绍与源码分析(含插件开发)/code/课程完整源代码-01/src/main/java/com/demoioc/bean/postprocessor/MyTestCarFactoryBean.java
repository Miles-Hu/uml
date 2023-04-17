package com.demoioc.bean.postprocessor;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.FactoryBean;

/**
 * 当配置文件中 <bean>的class属性配置的实现类是FactoryBean时，
 * 通过getBean方法返回的不是FactoryBean本身，而是 FactoryBean#getObject()方法所返回的对象，
 * 相当于FactoryBean#getObject()代理了getBean()方 法。
 */
@Log4j
public class MyTestCarFactoryBean implements FactoryBean {
	private String carInfo;

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	/*
	 * (non-Javadoc)
	 * 返回有FactoryBean创建的Bean实例，如果isSingleton()返回true,则该实例会放到Spring容器的单实例缓存池中。 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	public Object getObject() throws Exception {
		log.info("called");
		MyTestCar car = new MyTestCar();
		String[] infos = carInfo.split(",");
		car.setId(Integer.valueOf(infos[0]));
		car.setName(infos[1]);
		return car;
	}

	/*
	 * 返回FactoryBean创建Bean的类型。
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@SuppressWarnings("unchecked")
	public Class getObjectType() {
		return MyTestCar.class;
	}

	/*
	 * 确定由FactoryBean创建Bean的作用域是singleton还是prototype
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	public boolean isSingleton() {
		return false;
	}

}
