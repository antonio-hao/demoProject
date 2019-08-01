package com.antonio.bean;

public class HelloBean {
	private String name="";
	private String sex="";
	
	public HelloBean(){
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public String getSex(){
		return this.sex;
	}

}
