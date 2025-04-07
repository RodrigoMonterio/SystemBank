package com.monterio.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CheckingAccountManagerTest_Ex6 {

	private CheckingAccountManager accountManager;

	@Test
	public void shouldTransferAmountSuccessfully() {
		// given
		int id1 = 1;
		int id2 = 2;
		CheckingAccount account1 = new CheckingAccount(id1, 200.0, true);
		CheckingAccount account2 = new CheckingAccount(id2, 0.0, true);

		List<CheckingAccount> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);

		accountManager = new CheckingAccountManager(accounts);

		// when
		boolean success = accountManager.transferAmount(id1, 100.0, id2);

		// then
		assertTrue(success);
		assertThat(account1.getBalance(), is(100.0));
		assertThat(account2.getBalance(), is(100.0));
	}

	@Test
	public void shouldNotTransferWhenInsufficientBalance() {
		// given
		int id1 = 1;
		int id2 = 2;
		CheckingAccount account1 = new CheckingAccount(id1, 100.0, true);
		CheckingAccount account2 = new CheckingAccount(id2, 0.0, true);

		List<CheckingAccount> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);

		accountManager = new CheckingAccountManager(accounts);

		// when
		boolean success = accountManager.transferAmount(id1, 200.0, id2);

		// then
		assertFalse("Transfer should not be allowed with insufficient balance", success);
		assertThat(account1.getBalance(), is(100.0));
		assertThat(account2.getBalance(), is(0.0));
	}
}