package com.revature.db;

import java.util.ArrayList;

public class Account {
	
	private int accountId;
	private int accountTypeId;
	private String accountNumber;
	private Float balance;
	private boolean isAChecking;
	private ArrayList<JointAccountUserProfile> listOfJointUserProfiles;

	public Account(int id, int accountTypeId, Float balance, String accountNumber) {
		this.accountId = id;
		this.accountTypeId = accountTypeId;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}	
	public String getPartialAccountNumber() {
		return accountNumber;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public boolean isAChecking() {
		return isAChecking;
	}
	public void setIsAChecking(boolean isAChecking) {
		this.isAChecking = isAChecking;
	}

	private void printAccount(Account anAccount) {
		System.out.println(anAccount.getAccountId());		
		System.out.println(anAccount.getAccountTypeId());
		System.out.println(anAccount.getPartialAccountNumber());
		System.out.println(anAccount.getBalance());
		
	}
	
}
