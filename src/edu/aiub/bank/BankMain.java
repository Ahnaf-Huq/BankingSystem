package edu.aiub.bank;

import java.util.ArrayList;

import edu.aiub.bank.model.Account;
import edu.aiub.bank.model.CurrentAccount;
import edu.aiub.bank.model.SavingsAccount;
import edu.aiub.bank.util.*;

public class BankMain {

	public static void main(String[] args) {
		Account.setInterestRate(0.04);
		Account a = AccountManager.createAccount("S1","112233",500,Account.SAVINGS_ACCOUNT);
		Account b = AccountManager.createAccount("C1","224466",900,Account.CURRENT_ACCOUNT);
		//System.out.println(a);
		//System.out.println(b);
//		Account [] accounts = new Account [10]; 
//		accounts[0] = a;
//		accounts[1] = b;
//		accounts[2] = AccountManager.createAccount("C2","224466",700,Account.CURRENT_ACCOUNT);
//		accounts[3] = AccountManager.createAccount("S2","1",800,Account.SAVINGS_ACCOUNT);
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(a);
		accounts.add(b);
		accounts.add(AccountManager.createAccount("C2","224466",700,Account.CURRENT_ACCOUNT));
		accounts.add(AccountManager.createAccount("S2","1",800,Account.SAVINGS_ACCOUNT));
		System.out.println("Total number of Accounts: "+accounts.size());


		for (Account obj :accounts) { 
			//Account obj = (Account) o;
			System.out.println(obj);
			if (obj instanceof SavingsAccount) {
				System.out.println("Savings Account");
				//obj.setInterestRate(0.04);
				((SavingsAccount) obj).updateBalanceWithInterest();
				
				System.out.println(obj);
			} else if (obj instanceof CurrentAccount) {
				System.out.println("Current Account");
			} else {
				System.out.println("Unknown Account");
			}
		}
		
		
		
		
		
	}

}














