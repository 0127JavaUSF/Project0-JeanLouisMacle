package com.revature.pages;

import java.util.ArrayList;

import com.revature.db.Account;

public class AddWithdrawMoneyPage extends LoggedIn{
	private static AddWithdrawMoneyPage theOnlyAddWithdrawMoneyPage;
	NavigationMenu navigationObject;
			

	public static AddWithdrawMoneyPage returnSingleton() {
		if (theOnlyAddWithdrawMoneyPage ==null) theOnlyAddWithdrawMoneyPage = new AddWithdrawMoneyPage();
		return theOnlyAddWithdrawMoneyPage;
	}

	private AddWithdrawMoneyPage()
	{
		this.setTitle(StringExternalizationUtility.getString("AddWithdrawMoneyPage.pageTitle")); //$NON-NLS-1$
		this.setExpectsIntOnlyAsEntry(false);
		
	}
	
	public void setPageToString() {
		//Personalized header
		this.setPersonalizedHeader();
		//Set the Content
		//Dynamic navigation menu	+ updating the data in the Navigation object
		ArrayList<Page> listOfPageObjects = this.getContent().getNavigationObject().getNavigationMenuPages();
		int index =0;
		String navigationString = "\n";		
		//Current account information
		int lastIntEntry  = Page.lastIntEntry;
		ArrayList<Account> checkingAccountList = Page.getCheckingAccountList();
		ArrayList<Account> savingsAccountList = Page.getSavingAccountList();
		Account currentAccount;
		if (lastIntEntry<= checkingAccountList.size()) currentAccount=checkingAccountList.get(lastIntEntry-1);
		else currentAccount = savingsAccountList.get(lastIntEntry - checkingAccountList.size() -1 );
		navigationString += "Account number"+"\t\t"+"Balance"+"\n";
		navigationString += currentAccount.getPartialAccountNumber()+"\t\t\t"+currentAccount.getBalance()+"\n\n";
		navigationString += "\n";
		navigationString += "\t"+StringExternalizationUtility.getString("AddWithdrawMoneyPage.AddMoneyOrWithdrawMoney")+"\n";
		listOfPageObjects.add(AddWithdrawMoneyPage.returnSingleton());
		navigationString += "\t"+StringExternalizationUtility.getString("AddWithdrawMoneyPage.GoBackToAccountMenu")+"\n";
		listOfPageObjects.add(AccountsHomePage.returnSingleton());
		
		
		this.getContent().getNavigationObject().setToString(navigationString);
		//Footer: No need to set the footer; default value
	}
}
