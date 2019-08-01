package com.activiti.variable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * 流程变量设置
 * @author hasee
 *
 */
public class VariableTest {
	ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 部署流程定义
	 */
	@Test
	public void test1(){
		DeploymentBuilder deploymentBuilder = pe.getRepositoryService().createDeployment();
		deploymentBuilder.addClasspathResource("com/activiti/variable/variable.bpmn");
		deploymentBuilder.addClasspathResource("com/activiti/variable/variable.png");
		Deployment deployment = deploymentBuilder.deploy();
	}
	
	/**
	 * 设置流程变量方式一：在启动流程实例时设置
	 */
	@Test
	public void test2(){
		String ProcessDefinitionKey = "variable";
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("key1", "value1");
		variables.put("key2", 200);
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey(ProcessDefinitionKey, variables);
		System.out.println(pi.getId());
	}
	
	/**
	 * 设置流程变量方式二：在办理任务时设置
	 */
	@Test
	public void test3(){
		String taskId = "32506";
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("user", new User(1,"小号"));
		pe.getTaskService().complete(taskId, variables);		
	}

	/**
	 * 设置流程变量方式三：使用RuntimeService的方法设置
	 */
	@Test
	public void test4(){
		String executionId = "17501";//流程实例ID
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("key5", "运行设置");
		pe.getRuntimeService().setVariables(executionId, variables);		
	}
	
	/**
	 * 设置流程变量方式四：使用TaskService的方法设置
	 */
	@Test
	public void test5(){
		String taskId = "20004";//流程实例ID
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("key6", "任务设置");
		pe.getTaskService().setVariables(taskId, variables);		
	}
	
	/**
	 * 获取流程变量方式一：使用RuntimeService的方法获取
	 */
	
	@Test
	public void test6(){
		String executionId = "32501";//流程实例ID
		Map<String,Object> variables = new HashMap<String,Object>();
		variables = pe.getRuntimeService().getVariables(executionId);
		Set<String> keys = variables.keySet();
		for (String key : keys) {
			System.out.println(key+" " + variables.get(key));
		}
	}
	
	/**
	 * 获取流程变量方式二：使用TaskService的方法获取
	 */	
	@Test
	public void test7(){
		String taskId = "35005";
		Map<String,Object> variables = new HashMap<String,Object>();
		variables = pe.getTaskService().getVariables(taskId);
		Set<String> keys = variables.keySet();
		for (String key : keys) {
			System.out.println(key+" " + variables.get(key));
		}
	}
}
