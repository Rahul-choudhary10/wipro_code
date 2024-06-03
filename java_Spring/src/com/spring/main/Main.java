package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String args[]) {
		String config_log = "/java_Spring/src/com/spring/resources/ApplicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_log);
		
	}
}
