package edu.aiub.bank.model;

public class Account {
	String accountHoldersName;
	String accountNumber;
	double balance;
	static double interestRate; // if 4% interest rate, it is 0.04
	public final static int SAVINGS_ACCOUNT = 0;
	public final static int CURRENT_ACCOUNT = 1;
	int typeOfAccount =-1;
	
	void deposit(double amount) {
		balance =  balance+amount;
	}
	void withdraw(double amount) {
		if(balance-amount >= 0) {
			balance = balance-amount;
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