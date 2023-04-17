package com.demoioc.beanfactory.postprocessor4encrypt;

public class AesUtils {

	public static String decrypt(String string, String encryptedString) {
		return encryptedString.replaceAll("*", "w");
	}

	public static String encrypt(String string, String value) {
		return value.replaceAll("w", "*");
	}

}
