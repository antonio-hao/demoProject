package com.activiti.spring;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringActivitiTest {
	
	@Test
	public void test1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/activiti/spring/applicationContext.xml");
		ProcessEngine pe = (ProcessEngine)ctx.getBean("processEngine");
		System.out.println(pe);
	}

}
