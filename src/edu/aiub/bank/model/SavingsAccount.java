package edu.aiub.bank.model;

import edu.aiub.bank.util.LowBalanceException;

public class SavingsAccount extends Account {
	final static double MIN_BALANCE = 100;
	
	public SavingsAccount(String name,String accNo,double balance) {
		super(name,accNo,balance);
		typeOfAccount = SAVINGS_ACCOUNT;
		
	}
	
	public void withdraw(double amount) throws LowBalanceException {
		if (balance-amount >= MIN_BALANCE) {
			balance = balance-amount;
		} else {
			throw new LowBalanceException();
		}
	}
	public void updateBalanceWithInterest() {
		balance =balance+(balance*interestRate);
		
	}
}