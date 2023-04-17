package com.demoioc.使用方法.工具类;

import lombok.extern.log4j.Log4j;
import org.springframework.util.SystemPropertyUtils;

@Log4j
public class Myapp {

	/**
	 * TODO
	 * @author wangtlc 
	 * @date 2015-11-29 下午7:58:55
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String test="1${ok}2";
	log.info( SystemPropertyUtils.resolvePlaceholders(test));


	}

}
