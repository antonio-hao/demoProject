package com.activiti.task.group;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
/**
 * 公共任务测试
 * @author hasee
 *
 */
public class GroupTaskTest {
	ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 部署流程定义
	 */
	@Test
	public void test1(){
		DeploymentBuilder deploymentBuilder = pe.getRepositoryService().createDeployment();
		deploymentBuilder.addClasspathResource("com/activiti/task/group/groupTask.bpmn");
		deploymentBuilder.addClasspathResource("com/activiti/task/group/groupTask.png");
		Deployment deployment = deploymentBuilder.deploy();
	}
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void test2(){
		pe.getRuntimeService().startProcessInstanceByKey("groupTask");
	}
	
	/**
	 * 办理个人任务
	 */
	@Test
	public void test3(){
		String taskId = "42502";
		pe.getTaskService().complete(taskId);
	}
	
	/**
	 * 查询公共任务列表
	 */
	@Test
	public void test4(){
		TaskQuery query = pe.getTaskService().createTaskQuery();
		String candidateUer = "李四";
		query.taskCandidateUser(candidateUer);
		List<Task> list = query.list();
		for (Task task : list) {
			System.out.println(task.getName());
		}
	}
	
	/**
	 * 拾取任务（将公共任务变为个人任务）
	 */
	@Test
	public void test5(){
		String taskId = "42502";
		String userId = "李四";
		pe.getTaskService().claim(taskId, userId );
	}
	
	/**
	 * 退回任务（将个人任务变为公共任务）
	 */
	@Test
	public void test6(){
		String taskId = "42502";
		String userId = null;
		pe.getTaskService().setAssignee(taskId, userId);
	}
	
}
