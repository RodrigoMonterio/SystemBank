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

	public boolean transferAmount(int sourceAccountId, double amount, int targetAccountId) {
		if (amount <= 0) return false;

		CheckingAccount source = findAccountById(sourceAccountId);
		CheckingAccount target = findAccountById(targetAccountId);

		if (source == null || target == null) return false;
		if (!source.isActive() || !target.isActive()) return false;
		if (source.getBalance() < amount) return false;

		source.setBalance(source.getBalance() - amount);
		target.setBalance(target.getBalance() + amount);

		return true;
	}
}
