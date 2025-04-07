package com.monterio.business;

public class Customer {

	private int id;
	private String name;
	private int age;
	private String email;
	private boolean active;
	private int checkingAccountId;

	public Customer(int id, String name, int age, String email, int checkingAccountId, boolean active) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.checkingAccountId = checkingAccountId;
		this.active = active;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCheckingAccountId() {
		return checkingAccountId;
	}

	public void setCheckingAccountId(int checkingAccountId) {
		this.checkingAccountId = checkingAccountId;
	}

	@Override
	public String toString() {
		return "=========================" + "\n"
				+ "Id: " + id + "\n"
				+ "Name: " + name + "\n"
				+ "Email: " + email + "\n"
				+ "Age: " + age + "\n"
				+ "Status: " + (active ? "Active" : "Inactive") + "\n"
				+ "=========================";
	}
}
