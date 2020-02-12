package com.revature.pages;

import java.util.ArrayList;

import com.revature.db.Account;

public class AccountPage extends LoggedIn {
	private static AccountPage theOnlyAccountPage;
	NavigationMenu navigationObject;
	private static Account acccount;
		

	public static AccountPage returnSingleton() {
		if (theOnlyAccountPage ==null) theOnlyAccountPage = new AccountPage();
		return theOnlyAccountPage;
	}

	private AccountPage()
	{
		this.setTitle(StringExternalizationUtility.getString("AccountPage.pageTitle")); //$NON-NLS-1$
		this.setExpectsIntOnlyAsEntry(true);
		
	}

	public static Account getAcccount() {
		return acccount;
	}

	public static void setAcccount(Account acccount) {
		AccountPage.acccount = acccount;
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
		Account currentAccount = Page.getCurrentAccount(lastIntEntry);
		navigationString += "Account number"+"\t\t"+"Balance"+"\n";
		navigationString += currentAccount.getPartialAccountNumber()+"\t\t\t"+currentAccount.getBalance()+"\n\n";
		navigationString += "Options";		
		navigationString += "\n";
		navigationString += "\t"+StringExternalizationUtility.getString("AccountPage.MoneyManagement")+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		index++;
		navigationString += index+"\t"+StringExternalizationUtility.getString("AccountPage.AddWithdrawMoney")+index+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		listOfPageObjects.add(AddWithdrawMoneyPage.returnSingleton());
		index++;
		navigationString += index+"\t"+StringExternalizationUtility.getString("AccountPage.TransferMoney")+index+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		listOfPageObjects.add(TransferMoneyPage.returnSingleton());
		index++;
		navigationString += index+"\t"+StringExternalizationUtility.getString("AccountPage.GoBackToAccountMenu")+index+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		listOfPageObjects.add(AccountsHomePage.returnSingleton());
		this.getContent().getNavigationObject().setToString(navigationString);
		//Footer: No need to set the footer; default value
		
	}
	

}
