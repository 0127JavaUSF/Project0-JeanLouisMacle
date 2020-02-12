package com.revature.pages;

import java.util.ArrayList;

public class TransferMoneyPage extends LoggedIn {
	private static TransferMoneyPage theOnlyTransferMoneyPage;
	NavigationMenu navigationObject;
			

	public static TransferMoneyPage returnSingleton() {
		if (theOnlyTransferMoneyPage ==null) theOnlyTransferMoneyPage = new TransferMoneyPage();
		return theOnlyTransferMoneyPage;
	}

	private TransferMoneyPage()
	{
		this.setTitle(StringExternalizationUtility.getString("TransferMoneyPage.pageTitle")); //$NON-NLS-1$
		this.setExpectsIntOnlyAsEntry(false);
		
	}
	
	public void setPageToString() {
		//Personalized header
		this.setPersonalizedHeader();
		//Dynamic navigation menu	+ updating the data in the Navigation object
		ArrayList<Page> listOfPageObjects = this.getContent().getNavigationObject().getNavigationMenuPages();
		int index =0;
		String navigationString = "\n";
		
		
		this.getContent().getNavigationObject().setToString(navigationString);
		//Footer: No need to set the footer; default value
		
	}
	
}
