package com.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

//通过注解方式链接数据库
@Entity
@Table(name="teacher")
@TableGenerator(name="teacher_GEN",
				table="GENERATOR_TABLE",
				pkColumnName="pk_key",
				valueColumnName="pk_value",
				pkColumnValue="Teacher",
				allocationSize=1
				)
@SequenceGenerator(name="teacherSEQ",sequenceName="teacherSEQ_DB")
public class Teacher {
	private int id;
	private String name;
	private String title;
	private Date birthDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="teacher_GEN")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="t_name",length=8)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


}
