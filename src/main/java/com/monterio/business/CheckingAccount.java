package com.monterio.business;

public class CheckingAccount {

	private int id;
	private double balance;
	private boolean active;

	public CheckingAccount(int id, double balance, boolean active) {
		this.id = id;
		this.balance = balance;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "=========================\n"
				+ "Id: " + id + "\n"
				+ "Balance: $" + balance + "\n"
				+ "Status: " + (active ? "Active" : "Inactive") + "\n"
				+ "=========================";
	}
}
