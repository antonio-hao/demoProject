package com.activiti.variable;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
