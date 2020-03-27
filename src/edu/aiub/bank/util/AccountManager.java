package edu.aiub.bank.util;

import edu.aiub.bank.model.*;

public class AccountManager {
	public static Account createAccount(String name,String accNo,double balance,int type) {
		if (type == Account.SAVINGS_ACCOUNT) {
			Account a = new SavingsAccount(name,accNo,balance);
			return a;
		} else if (type == Account.CURRENT_ACCOUNT) {
			Account a = new CurrentAccount(name,accNo,balance);
			return a;
		}
		return null;
	}
	public static void transferMoney(Account from,Account to,double amount){
		try{
			from.withdraw(amount);
			to.deposit(amount);
		} catch(LowBalanceException lx) {
			System.out.println("You do not have sufficient balance to transfer.");
			lx.printStackTrace();
		}
		
	}
}