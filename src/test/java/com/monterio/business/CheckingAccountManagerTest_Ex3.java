package com.monterio.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CheckingAccountManagerTest_Ex3 {

	private CheckingAccountManager accountManager;

	@Test
	public void shouldTransferAmountBetweenAccounts() {
		// given
		CheckingAccount account1 = new CheckingAccount(1, 200, true);
		CheckingAccount account2 = new CheckingAccount(2, 0, true);

		List<CheckingAccount> bankAccounts = new ArrayList<>();
		bankAccounts.add(account1);
		bankAccounts.add(account2);

		accountManager = new CheckingAccountManager(bankAccounts);

		// when
		boolean success = accountManager.transferAmount(1, 100, 2);

		// then
		assertTrue(success);
		assertThat(account1.getBalance(), is(100.0));
		assertThat(account2.getBalance(), is(100.0));
	}
}