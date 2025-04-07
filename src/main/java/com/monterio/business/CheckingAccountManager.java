package com.monterio.business;

import java.util.List;

public class CheckingAccountManager {

	private List<CheckingAccount> bankAccounts;

	public CheckingAccountManager(List<CheckingAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<CheckingAccount> getBankAccounts() {
		return bankAccounts;
	}

	public CheckingAccount findAccountById(int accountId) {
		for (CheckingAccount account : bankAccounts) {
			if (account.getId() == accountId)
				return account;
		}
		return null;
	}

	public void addAccount(CheckingAccount newAccount) {
		this.bankAccounts.add(newAccount);
	}

	public boolean removeAccountById(int accountId) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			CheckingAccount account = bankAccounts.get(i);
			if (account.getId() == accountId) {
				bankAccounts.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean isAccountActive(int accountId) {
		for (CheckingAccount account : bankAccounts) {
			if (account.getId() == accountId && account.isActive()) {
				return true;
			}
		}
		return false;
	}

	public boolean transferAmount(int sourceAccountId, double amount, int destinationAccountId) {
		CheckingAccount sourceAccount = findAccountById(sourceAccountId);
		CheckingAccount destinationAccount = findAccountById(destinationAccountId);

		if (sourceAccount == null || destinationAccount == null) {
			return false;
		}

		if (sourceAccount.getBalance() >= amount) {
			sourceAccount.setBalance(sourceAccount.getBalance() - amount);
			destinationAccount.setBalance(destinationAccount.getBalance() + amount);
			return true;
		}

		return false;
	}
}
