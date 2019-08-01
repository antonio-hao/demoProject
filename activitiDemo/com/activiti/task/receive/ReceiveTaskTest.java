package com.activiti.task.receive;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class ReceiveTaskTest {
	ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 部署流程定义
	 */
	@Test
	public void test1(){
		DeploymentBuilder deploymentBuilder = pe.getRepositoryService().createDeployment();
		deploymentBuilder.addClasspathResource("com/activiti/task/receive/receive.bpmn");
		deploymentBuilder.addClasspathResource("com/activiti/task/receive/receive.png");
		Deployment deployment = deploymentBuilder.deploy();
	}
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void test2(){
		pe.getRuntimeService().startProcessInstanceByKey("reciveTask");
	}
	
	/**
	 * 办理任务
	 */
	@Test
	public void test3(){
		String taskId = "52504";
		pe.getTaskService().complete(taskId);
	}
	
	/**
	 * 处理接收任务
	 */
	@Test
	public void test4(){
		String executionId = "52501";
		pe.getRuntimeService().signal(executionId);
	}
}
