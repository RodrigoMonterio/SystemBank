package com.monterio.business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerManagerTest_Ex8 {

	private CustomerManager customerManager;
	private int customerId1 = 1;
	private int customerId2 = 2;

	@Before
	public void setUp() {
		Customer customer1 = new Customer(customerId1, "Isaac Newton", 50, "newton@bank.com", 1, true);
		Customer customer2 = new Customer(customerId2, "Albert Einstein", 40, "einstein@bank.com", 1, true);

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
		Customer customer = customerManager.findCustomerById(customerId1);
		assertThat(customer.getId(), is(customerId1));
		assertThat(customer.getName(), is("Isaac Newton"));
		assertThat(customer.getEmail(), is("newton@bank.com"));
	}

	@Test
	public void shouldRemoveCustomerById() {
		boolean removed = customerManager.removeCustomerById(customerId2);

		assertTrue(removed);
		assertThat(customerManager.getBankCustomers().size(), is(1));
		assertNull(customerManager.findCustomerById(customerId2));
	}
}