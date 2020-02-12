package com.revature.pages;

import java.util.ArrayList;

import com.revature.db.Account;

public class AccountManagementPage extends LoggedIn {
	private static AccountManagementPage theOnlyAccountManagementPage;
	NavigationMenu navigationObject;
		

	public static AccountManagementPage returnSingleton() {
		if (theOnlyAccountManagementPage ==null) theOnlyAccountManagementPage = new AccountManagementPage();
		return theOnlyAccountManagementPage;
	}

	private AccountManagementPage()
	{
		this.setTitle(StringExternalizationUtility.getString("AccountManagementPage.pageTitle")); //$NON-NLS-1$
		this.setExpectsIntOnlyAsEntry(true);
		
	}
	
	public void setPageToString() {
		//Personalized header
		this.setPersonalizedHeader();
		
		//Set the Content
		//Dynamic navigation menu	+ updating the data in the Navigation object
		ArrayList<Page> listOfPageObjects = this.getContent().getNavigationObject().getNavigationMenuPages();
		int index =0;
		String navigationString = "Options\n";
		navigationString += "\t"+StringExternalizationUtility.getString("AccountPage.AccountManagement")+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		index++;
		navigationString += index+"\t"+StringExternalizationUtility.getString("AccountPage.OpenAccount")+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		index++;
		navigationString += index+"\t"+StringExternalizationUtility.getString("AccountPage.CloseAccount")+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		index++;
		navigationString += index+"\t"+StringExternalizationUtility.getString("AccountPage.GoBackToAccountMenu")+index+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		this.getContent().getNavigationObject().setToString(navigationString);
		//Footer: No need to set the footer; default value
		
	}

}
