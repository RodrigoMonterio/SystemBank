package com.monterio.business;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CustomerManagerTest_Ex1 {

	@Test
	public void shouldFindCustomerById() {
		Customer customer01 = new Customer(1, "Albert Einstein", 40, "einstein@bank.com", 1, true);
		Customer customer02 = new Customer(2, "Marie Curie", 38, "curie@bank.com", 2, true);

		List<Customer> bankCustomers = new ArrayList<>();
		bankCustomers.add(customer01);
		bankCustomers.add(customer02);

		CustomerManager customerManager = new CustomerManager(bankCustomers);

		Customer result = customerManager.findCustomerById(1);

		assertThat(result.getId(), is(1));
		assertThat(result.getEmail(), is("einstein@bank.com"));
	}
}
