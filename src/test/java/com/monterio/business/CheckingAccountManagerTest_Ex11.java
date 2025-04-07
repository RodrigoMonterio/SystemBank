package com.monterio.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CheckingAccountManagerTest_Ex11 {

	private CheckingAccountManager accountManager;

	private void setupAccounts(double balance1, boolean active1, double balance2, boolean active2) {
		CheckingAccount acc1 = new CheckingAccount(1, balance1, active1);
		CheckingAccount acc2 = new CheckingAccount(2, balance2, active2);
		List<CheckingAccount> accounts = List.of(acc1, acc2);
		accountManager = new CheckingAccountManager(accounts);
	}

	@Test
	public void shouldTransferAmountSuccessfully() {
		setupAccounts(200.0, true, 0.0, true);
		boolean success = accountManager.transferAmount(1, 100.0, 2);
		assertTrue(success);
		assertThat(accountManager.findAccountById(1).getBalance(), is(100.0));
		assertThat(accountManager.findAccountById(2).getBalance(), is(100.0));
	}

	@Test
	public void shouldNotTransferWithInsufficientBalance() {
		setupAccounts(100.0, true, 0.0, true);
		boolean success = accountManager.transferAmount(1, 200.0, 2);
		assertFalse(success);
		assertThat(accountManager.findAccountById(1).getBalance(), is(100.0));
		assertThat(accountManager.findAccountById(2).getBalance(), is(0.0));
	}

	@Test
	public void shouldNotTransferWhenSourceHasNegativeBalance() {
		setupAccounts(-100.0, true, 0.0, true);
		boolean success = accountManager.transferAmount(1, 50.0, 2);
		assertFalse(success);
		assertThat(accountManager.findAccountById(1).getBalance(), is(-100.0));
		assertThat(accountManager.findAccountById(2).getBalance(), is(0.0));
	}

	@Test
	public void shouldNotTransferFromNegativeToNegative() {
		setupAccounts(-100.0, true, -100.0, true);
		boolean success = accountManager.transferAmount(1, 50.0, 2);
		assertFalse(success);
		assertThat(accountManager.findAccountById(1).getBalance(), is(-100.0));
		assertThat(accountManager.findAccountById(2).getBalance(), is(-100.0));
	}

	@Test
	public void shouldNotTransferZeroAmount() {
		setupAccounts(100.0, true, 100.0, true);
		boolean success = accountManager.transferAmount(1, 0.0, 2);
		assertFalse(success);
		assertThat(accountManager.findAccountById(1).getBalance(), is(100.0));
		assertThat(accountManager.findAccountById(2).getBalance(), is(100.0));
	}
}