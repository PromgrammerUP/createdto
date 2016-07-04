package org.javachina.createdto.dto;

public class PersonDto {
	private int id;

	public void setId(int s) {
		this.id = s;
	}

	public int getId() {
		return this.id;
	}

	private int departmentid;

	public void setDepartmentid(int s) {
		this.departmentid = s;
	}

	public int getDepartmentid() {
		return this.departmentid;
	}

	private int salary;

	public void setSalary(int s) {
		this.salary = s;
	}

	public int getSalary() {
		return this.salary;
	}

	private String address;

	public void setAddress(String s) {
		this.address = s;
	}

	public String getAddress() {
		return this.address;
	}

	private String username;

	public void setUsername(String s) {
		this.username = s;
	}

	public String getUsername() {
		return this.username;
	}
}