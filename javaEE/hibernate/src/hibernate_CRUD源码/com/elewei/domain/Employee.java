package com.elewei.domain;

import java.io.Serializable;

//domain/javabean/pojo
//该pojo按照规范应当序列化，目的是可以唯一的标识该对象
public class Employee implements Serializable {
	private Integer id;
	private String name;
	private String email;
	private java.util.Date hiredate;
	private float salary;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
}
