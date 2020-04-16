package edu.aiub.bank.model;

import edu.aiub.bank.util.LowBalanceException;

public interface AccountInterface {
	
	public final static int SAVINGS_ACCOUNT = 0;
	public final static int CURRENT_ACCOUNT = 1;
	
	void deposit(double amount);
	void withdraw(double amount) throws LowBalanceException;

} 

