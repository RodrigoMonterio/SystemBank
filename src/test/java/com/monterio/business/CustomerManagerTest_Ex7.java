package com.monterio.business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerManagerTest_Ex7 {

	private CustomerManager customerManager;
	private int customerId1 = 1;
	private int customerId2 = 2;

	@Before
	public void setUp() {
		Customer customer1 = new Customer(customerId1, "Marie Curie", 38, "curie@bank.com", 1, true);
		Customer customer2 = new Customer(customerId2, "Stephen Hawking", 42, "hawking@bank.com", 1, true);

		List<Customer> bankCustomers = new ArrayList<>();
		bankCustomers.add(customer1);
		bankCustomers.add(customer2);

		customerManager = new CustomerManager(bankCustomers);
	}

	@After
	public void tearDown() {
		customerManager.clear();
	}

	@Test
	public void shouldFindCustomerById() {
		Customer result = customerManager.findCustomerById(customerId1);
		assertThat(result.getId(), is(customerId1));
		assertThat(result.getName(), is("Marie Curie"));
		assertThat(result.getEmail(), is("curie@bank.com"));
	}

	@Test
	public void shouldRemoveCustomerById() {
		boolean removed = customerManager.removeCustomerById(customerId2);
		assertTrue(removed);
		assertThat(customerManager.getBankCustomers().size(), is(1));
		assertNull(customerManager.findCustomerById(customerId2));
	}
}
