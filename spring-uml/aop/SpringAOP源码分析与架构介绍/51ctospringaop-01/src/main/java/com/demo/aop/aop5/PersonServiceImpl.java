package com.demo.aop.aop5;

import org.springframework.stereotype.Service;

import com.demo.aop.aop5.interceptor2.MyAnnotation;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class PersonServiceImpl implements PersonService {
	
	@MyAnnotation
	public void save(String name) {
		log.info("save");
	}

}