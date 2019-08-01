package com.activiti.listener.task;

import java.util.Set;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener2 implements TaskListener{

	//监听任务事件
	@Override
	public void notify(DelegateTask delegateTask) {
		String assignee = delegateTask.getAssignee();
		String eventName = delegateTask.getEventName();
		String name = delegateTask.getName();
		String processInstanceId = delegateTask.getProcessInstanceId();
		Set<String> variableNames = delegateTask.getVariableNames();
		for (String key : variableNames) {
			Object variable = delegateTask.getVariable(key);
			System.out.println(key + " = " + variable);
		}
		System.out.println("一个任务[" + name + "]被办理了,由[" + assignee +"]负责办理。("+ processInstanceId + ":"  + eventName + ")");
		
	}

}
