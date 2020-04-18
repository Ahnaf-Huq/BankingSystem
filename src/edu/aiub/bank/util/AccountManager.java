package edu.aiub.bank.util;

import java.util.ArrayList;
import java.util.List;

import edu.aiub.bank.model.*;

public class AccountManager {
	
	private static AccountManager instance;
	
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	private AccountManager() {}
	
	public static AccountManager getInstance() {
		if (instance == null) {
			instance = new AccountManager();
		}
		
		return instance;
	}
	
	public void add(Account ac) {
		accounts.add(ac);
	}
	public int size() {
		return accounts.size();
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public Account search (String accNo) {
		for(Account a: accounts) {
			if(accNo.equals(a.getAccountNumber())) {
				//System.out.println("Account found.");
				return a;
			}
		} 
		return null;
	}
	
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