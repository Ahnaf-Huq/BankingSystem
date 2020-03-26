package edu.aiub.bank.model;

public class SavingsAccount extends Account {
	final static double MIN_BALANCE = 100;
	
	public SavingsAccount(String name,String accNo,double balance) {
		super(name,accNo,balance);
		typeOfAccount = SAVINGS_ACCOUNT;
		
	}
	
	void withdraw(double amount) {
		if (balance-amount >= MIN_BALANCE) {
			balance = balance-amount;
		}
	}
	public void updateBalanceWithInterest() {
		balance =balance+(balance*interestRate);
		
	}
}