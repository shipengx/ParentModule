package com.shipeng.dto;

public class Student {
	
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	
	public Student(Integer id, String name, Integer age, String address) {
		this.id      = id;
		this.name    = name;
		this.age     = age;
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String toString() {
		return "[Student] - id=" + id + ",name=" + name + ",age=" + age + ",address=" + address;
	}
}