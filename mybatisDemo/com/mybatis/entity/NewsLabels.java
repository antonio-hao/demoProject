package com.mybatis.entity;

import java.util.Set;

//新闻栏目：当前的新闻栏目被看作是多方。即子栏目
public class NewsLabels {
	private Integer id;
	private String name;
	private NewsLabels parent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NewsLabels getParent() {
		return parent;
	}
	public void setParent(NewsLabels parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "NewsLabels [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}
	
}
