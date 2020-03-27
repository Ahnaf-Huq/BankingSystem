package edu.aiub.bank.model;

import edu.aiub.bank.util.LowBalanceException;

public class Account implements AccountInterface {
	String accountHoldersName;
	String accountNumber;
	double balance;
	static double interestRate; // if 4% interest rate, it is 0.04
	
	int typeOfAccount =-1;
	
	public void deposit(double amount) {
		balance =  balance+amount;
	}
	public void withdraw(double amount) throws LowBalanceException {
		if(balance-amount >= 0) {
			balance = balance-amount;
		} else {
			throw new LowBalanceException();
		}
	} 
	Account(){
		
	}
	public Account(String name,String accNo,double balance){
		accountHoldersName = name;
		accountNumber = accNo;
		this.balance = balance;
	}
	public String getAccountHoldersName() {
		return accountHoldersName;
	}
	public void setAccountHoldersName(String accountHoldersName) {
		this.accountHoldersName = accountHoldersName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static double getInterestRate() {
		return interestRate;
	}
	public static void setInterestRate(double r) {
		interestRate = r;
	}
	public String toString() {
		return "Account Name: "+accountHoldersName
				+",Account Number: "+accountNumber
				+",Balance: "+balance+",Type: "+typeOfAccount;
		
	}
	
	
	
}