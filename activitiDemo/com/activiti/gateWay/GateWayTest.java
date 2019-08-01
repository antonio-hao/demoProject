package com.activiti.gateWay;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class GateWayTest {
	ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 部署流程定义
	 */
	@Test
	public void test1(){
		DeploymentBuilder deploymentBuilder = pe.getRepositoryService().createDeployment();
		deploymentBuilder.addClasspathResource("com/activiti/gateWay/gateWay2.bpmn");
		deploymentBuilder.addClasspathResource("com/activiti/gateWay/gateWay2.png");
		Deployment deployment = deploymentBuilder.deploy();
	}
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void test2(){
		String processDefinitionKey = "gateWay2";		
		pe.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
	}
	
	/**
	 * 办理任务
	 */
	@Test
	public void test4(){
		String taskId = "142504";
		Map<String,Object> variables =new HashMap<String,Object>();
		variables.put("bxje", 600);
		pe.getTaskService().complete(taskId,variables);
	}
}
