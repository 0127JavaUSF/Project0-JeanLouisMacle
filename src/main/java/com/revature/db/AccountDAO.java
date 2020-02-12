package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pages.Page;

public class AccountDAO implements DAO<Account> {

	@Override
	public void save(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		
	}
	
	public Account getAccount(int id) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "Select accountId, accountTypeId, accountNumber, balance from Account where accountId = ?;";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				int accountTypeId = result.getInt("accountTypeId");
				String accountNumber = result.getString("accountNumber");
				Float balance = result.getFloat("balance");
				return new Account(id,accountTypeId,balance,accountNumber);
				
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}		
		return null;
	}

	public void retrieveAccountLists(int clientId) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "Select accountId, accountTypeId, accountNumber, balance from Account where accountTypeId = ?;";
		ArrayList<ArrayList<Account>> sortedAccountList = new ArrayList();
		ArrayList<Account> checkingAccountList = new ArrayList();
		ArrayList<Account> savingAccountList = new ArrayList();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,1);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int accountId = result.getInt("accountId");
				String accountNumber = result.getString("accountNumber");
				Float balance = result.getFloat("balance");
				Account storedAccount = new Account(accountId,1,balance,accountNumber);
				checkingAccountList.add(storedAccount);	
				//this.printAccount(storedAccount);
			}
			Page.setCheckingAccountList(checkingAccountList);
			
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1,2);
			result = statement.executeQuery();
			while (result.next()) {
				int accountId = result.getInt("accountId");
				String accountNumber = result.getString("accountNumber");
				Float balance = result.getFloat("balance");
				Account storedAccount = new Account(accountId,2,balance,accountNumber);
				savingAccountList.add(storedAccount);	
				//this.printAccount(storedAccount);
							
			}
			Page.setSavingAccountList(savingAccountList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) {
//		AccountDAO dao = new AccountDAO();
//		Account testAccount = dao.getAccount(1);
//		System.out.println(testAccount.getAccountId());
//		System.out.println(testAccount.getPartialAccountNumber());
//		System.out.println(testAccount.getBalance());
//		
//		ArrayList<ArrayList<Account>> sortedList = dao.getSortedAccountList();
//		ArrayList<Account> checkingAccountList = sortedList.get(0);
//		ArrayList<Account> savingAccountList = sortedList.get(1);
//		
//		System.out.println("Printing Checking Account List Data");
//		for (Account anAccount: checkingAccountList ) {
//			dao.printAccount(anAccount);			
//		}
//		
//		System.out.println("Printing Saving Account List Data");
//		for (Account anAccount: savingAccountList ) {
//			dao.printAccount(anAccount);			
//		}
	
		
//		
//	}
}