package edu.aiub.bank.model;

public class CurrentAccount extends Account{
	public CurrentAccount(String name,String accNo,double balance){
		super(name,accNo,balance);
		typeOfAccount = CURRENT_ACCOUNT;
	}
}