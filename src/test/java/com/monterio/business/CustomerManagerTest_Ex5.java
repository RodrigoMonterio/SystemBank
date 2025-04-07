package com.monterio.business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CustomerManagerTest_Ex5 {

	private CustomerManager customerManager;

	@Test
	public void shouldFindCustomerById() {
		int customerId1 = 1;
		int customerId2 = 2;

		Customer customer1 = new Customer(customerId1, "Galileo Galilei", 60, "galileo@bank.com", 1, true);
		Customer customer2 = new Customer(customerId2, "Erwin Schrödinger", 46, "schrodinger@bank.com", 1, true);

		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);

		customerManager = new CustomerManager(customers);

		Customer result = customerManager.findCustomerById(customerId1);

		assertThat(result.getId(), is(customerId1));
		assertThat(result.getName(), is("Galileo Galilei"));
		assertThat(result.getEmail(), is("galileo@bank.com"));
	}

	@Test
	public void shouldRemoveCustomerById() {
		int customerId1 = 1;
		int customerId2 = 2;

		Customer customer1 = new Customer(customerId1, "Galileo Galilei", 60, "galileo@bank.com", 1, true);
		Customer customer2 = new Customer(customerId2, "Erwin Schrödinger", 46, "schrodinger@bank.com", 1, true);

		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);

		customerManager = new CustomerManager(customers);

		boolean removed = customerManager.removeCustomerById(customerId2);

		assertTrue(removed);
		assertThat(customerManager.getBankCustomers().size(), is(1));
		assertNull(customerManager.findCustomerById(customerId2));
	}
}