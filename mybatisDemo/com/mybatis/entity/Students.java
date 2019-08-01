package com.mybatis.entity;

import java.util.Set;

public class Students {
	private Integer sid;
	private String sname;
	private Set<Course> courses;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}
}
