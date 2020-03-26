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
}