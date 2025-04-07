package com.monterio.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for basic operations performed by {@link CheckingAccountManager}.
 */
public class CheckingAccountManagerTest_Ex4 {

	private CheckingAccountManager accountManager;

	@Test
	public void shouldTransferAmountSuccessfully() {
		// given
		CheckingAccount account1 = new CheckingAccount(1, 200.0, true);
		CheckingAccount account2 = new CheckingAccount(2, 0.0, true);

		List<CheckingAccount> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);

		accountManager = new CheckingAccountManager(accounts);

		// when
		boolean success = accountManager.transferAmount(1, 100.0, 2);

		// then
		assertTrue(success);
		assertThat(account1.getBalance(), is(100.0));
		assertThat(account2.getBalance(), is(100.0));
	}
}
