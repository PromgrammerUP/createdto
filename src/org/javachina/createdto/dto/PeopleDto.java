package org.javachina.createdto.dto;

public class PeopleDto {
	private int salary;

	public void setSalary(int s) {
		this.salary = s;
	}

	public int getSalary() {
		return this.salary;
	}

	private java.sql.Date birth;

	public void setBirth(java.sql.Date s) {
		this.birth = s;
	}

	public java.sql.Date getBirth() {
		return this.birth;
	}

	private int age;

	public void setAge(int s) {
		this.age = s;
	}

	public int getAge() {
		return this.age;
	}

	private String name;

	public void setName(String s) {
		this.name = s;
	}

	public String getName() {
		return this.name;
	}

	private int id;

	public void setId(int s) {
		this.id = s;
	}

	public int getId() {
		return this.id;
	}
}