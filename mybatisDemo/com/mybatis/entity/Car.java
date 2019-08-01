package com.mybatis.entity;

public class Car {
	private Integer cid;
	private String cname;
	private Person person;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + ", person=" + person + "]";
	}
}
