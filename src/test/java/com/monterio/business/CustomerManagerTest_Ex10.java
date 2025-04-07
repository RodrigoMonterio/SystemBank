package com.monterio.business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerManagerTest_Ex10 {

	private CustomerManager customerManager;
	private int customerId1 = 1;
	private int customerId2 = 2;

	@Before
	public void setUp() {
		Customer customer1 = new Customer(customerId1, "Max Planck", 55, "planck@bank.com", 1, true);
		Customer customer2 = new Customer(customerId2, "Marie Curie", 38, "curie@bank.com", 1, true);

		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);

		customerManager = new CustomerManager(customers);
	}

	@After
	public void tearDown() {
		customerManager.clear();
	}

	@Test
	public void shouldFindCustomerById() {
		Customer result = customerManager.findCustomerById(customerId1);
		assertThat(result.getId(), is(customerId1));
	}

	@Test
	public void shouldReturnNullWhenCustomerNotFound() {
		Customer result = customerManager.findCustomerById(1001);
		assertNull(result);
	}

	@Test
	public void shouldRemoveCustomerById() {
		boolean removed = customerManager.removeCustomerById(customerId2);
		assertTrue(removed);
		assertThat(customerManager.getBankCustomers().size(), is(1));
		assertNull(customerManager.findCustomerById(customerId2));
	}

	@Test
	public void shouldNotRemoveCustomerWhenIdDoesNotExist() {
		boolean removed = customerManager.removeCustomerById(1001);
		assertFalse(removed);
		assertThat(customerManager.getBankCustomers().size(), is(2));
	}

	@Test
	public void shouldValidateAgeWhenInValidRange() throws InvalidAgeException {
		Customer validCustomer = new Customer(3, "Niels Bohr", 25, "bohr@bank.com", 1, true);
		boolean isValid = customerManager.validateAge(validCustomer.getAge());
		assertTrue(isValid);
	}

	@Test
	public void shouldValidateAgeAtLowerBoundary() throws InvalidAgeException {
		Customer validCustomer = new Customer(3, "Galileo Galilei", 18, "galileo@bank.com", 1, true);
		assertTrue(customerManager.validateAge(validCustomer.getAge()));
	}

	@Test
	public void shouldValidateAgeAtUpperBoundary() throws InvalidAgeException {
		Customer validCustomer = new Customer(3, "Richard Feynman", 65, "feynman@bank.com", 1, true);
		assertTrue(customerManager.validateAge(validCustomer.getAge()));
	}

	@Test
	public void shouldThrowExceptionWhenAgeBelowMinimum() {
		Customer invalidCustomer = new Customer(3, "Stephen Hawking", 17, "hawking@bank.com", 1, true);
		try {
			customerManager.validateAge(invalidCustomer.getAge());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(InvalidAgeException.INVALID_AGE_MSG));
		}
	}

	@Test
	public void shouldThrowExceptionWhenAgeAboveMaximum() {
		Customer invalidCustomer = new Customer(3, "Albert Einstein", 66, "einstein@bank.com", 1, true);
		try {
			customerManager.validateAge(invalidCustomer.getAge());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(InvalidAgeException.INVALID_AGE_MSG));
		}
	}
}