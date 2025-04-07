package com.monterio.business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CustomerManagerTest_Ex3 {

	private CustomerManager customerManager;

	@Test
	public void shouldFindCustomerById() {
		Customer customer1 = new Customer(1, "Richard Feynman", 45, "feynman@bank.com", 1, true);
		Customer customer2 = new Customer(2, "Niels Bohr", 39, "bohr@bank.com", 1, true);

		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);

		customerManager = new CustomerManager(customers);

		Customer result = customerManager.findCustomerById(1);

		assertThat(result.getId(), is(1));
		assertThat(result.getName(), is("Richard Feynman"));
		assertThat(result.getEmail(), is("feynman@bank.com"));
	}

	@Test
	public void shouldRemoveCustomerById() {
		Customer customer1 = new Customer(1, "Richard Feynman", 45, "feynman@bank.com", 1, true);
		Customer customer2 = new Customer(2, "Niels Bohr", 39, "bohr@bank.com", 1, true);

		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);

		customerManager = new CustomerManager(customers);

		boolean removed = customerManager.removeCustomerById(2);

		assertTrue(removed);
		assertThat(customerManager.getBankCustomers().size(), is(1));
		assertNull(customerManager.findCustomerById(2));
	}
}
