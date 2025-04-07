package com.monterio.business;

import java.util.List;

public class CustomerManager {

	private List<Customer> bankCustomers;

	public CustomerManager(List<Customer> bankCustomers) {
		this.bankCustomers = bankCustomers;
	}

	public List<Customer> getBankCustomers() {
		return bankCustomers;
	}

	public Customer findCustomerById(int customerId) {
		for (Customer customer : bankCustomers) {
			if (customer.getId() == customerId)
				return customer;
		}
		return null;
	}

	public void addCustomer(Customer newCustomer) {
		bankCustomers.add(newCustomer);
	}

	public boolean removeCustomerById(int customerId) {
		for (int i = 0; i < bankCustomers.size(); i++) {
			Customer customer = bankCustomers.get(i);
			if (customer.getId() == customerId) {
				bankCustomers.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean isCustomerActive(int customerId) {
		for (Customer customer : bankCustomers) {
			if (customer.getId() == customerId && customer.isActive()) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		this.bankCustomers.clear();
	}

	public boolean validateAge(int age) throws InvalidAgeException {
		if (age < 18 || age > 65) {
			throw new InvalidAgeException(InvalidAgeException.INVALID_AGE_MSG);
		}
		return true;
	}
}
