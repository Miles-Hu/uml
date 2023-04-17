package com.demoioc.bean.postprocessor;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.FactoryBean;

/**
 * �������ļ��� <bean>��class�������õ�ʵ������FactoryBeanʱ��
 * ͨ��getBean�������صĲ���FactoryBean�������� FactoryBean#getObject()���������صĶ���
 * �൱��FactoryBean#getObject()������getBean()�� ����
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
	 * ������FactoryBean������Beanʵ�������isSingleton()����true,���ʵ����ŵ�Spring�����ĵ�ʵ��������С� 
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
	 * ����FactoryBean����Bean�����͡�
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@SuppressWarnings("unchecked")
	public Class getObjectType() {
		return MyTestCar.class;
	}

	/*
	 * ȷ����FactoryBean����Bean����������singleton����prototype
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	public boolean isSingleton() {
		return false;
	}

}
