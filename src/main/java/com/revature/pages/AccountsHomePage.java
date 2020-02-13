package com.revature.pages;

import java.util.ArrayList;

import com.revature.db.Account;
import com.revature.db.AccountDAO;
import com.revature.db.UserProfile;
import com.revature.db.UserProfileDAO;

public class AccountsHomePage extends LoggedIn {
	private static AccountsHomePage theOnlyAccountsHomePage;
	NavigationMenu navigationObject;
	
	/*  Retrieves all account data available for the user and populates Account objects */
	/*  Structure containing the Account objects, with ability to differentiate between savings and checking accounts   */
	/*  Those objects are accessible from all pages after the user has logged in. */

	
	/*Options 1,2,3,4 related to 4 Account objects, to use with an Account Page */
	/* Option 5 Account management Page*/
	/*  Option 6 User Profile Page*/
	 public static AccountsHomePage returnSingleton() {
		if (theOnlyAccountsHomePage ==null) theOnlyAccountsHomePage = new AccountsHomePage();
		return theOnlyAccountsHomePage;
	}
	
	private AccountsHomePage()
	{
		this.setTitle(StringExternalizationUtility.getString("AccountsHomePage.pageTitle")); //$NON-NLS-1$
		/*TODO: add a dynamic number of AccountPage objects + Account Management Page + Personal Information Page*/	
		this.setExpectsIntOnlyAsEntry(true);
		
	}
	
	
	public void setPageToString() {
		if(Page.getUserProfile()!= null) {
		
			//Personalized header
			this.setPersonalizedHeader();
			
			//Set the Content
				//Dynamic navigation menu	+ updating the data in the Navigation object
			ArrayList<Page> listOfPageObjects = this.getContent().getNavigationObject().getNavigationMenuPages();
			
			String navigationString = "Options\n"; //$NON-NLS-1$
			navigationString += "\tCHECKING ACCOUNTS\n"; //$NON-NLS-1$
			int index = 0;
			ArrayList<String> headerItems = new ArrayList();
			headerItems.add("Account number"); //$NON-NLS-1$
			headerItems.add("Account balance"); //$NON-NLS-1$
			//navigationString += "Account number"+"\t\t"+"Account balance"+"\n";
			navigationString += tabFormating(headerItems);
			for (Account cAccount:Page.getCheckingAccountList())
			{
				index++;
				listOfPageObjects.add(AccountPage.returnSingleton());
				navigationString += index+"\t"+cAccount.getAccountNumber()+"\t\t\t"+cAccount.getBalance()+"\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			navigationString += "\n"; //$NON-NLS-1$
			navigationString += "\tSAVINGS ACCOUNTS"; //$NON-NLS-1$
			navigationString += "\n"; //$NON-NLS-1$
			headerItems.clear();
			headerItems.add("Account number"); //$NON-NLS-1$
			headerItems.add("Account balance");					 //$NON-NLS-1$
			for (Account cAccount:Page.getSavingAccountList())
			{
				index++;
				listOfPageObjects.add(AccountPage.returnSingleton());
				navigationString += index+"\t"+cAccount.getAccountNumber()+"\t\t\t"+cAccount.getBalance()+"\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			navigationString += "\t"+StringExternalizationUtility.getString("AccountsHomePage.Add_Withdraw_Transfer")+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
			navigationString += "\t"+StringExternalizationUtility.getString("AccountsHomePage.Add_Close_Account")+Page.pressReturnKeyText+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
			
			this.getContent().getNavigationObject().setToString(navigationString);
		//Footer: No need to set the footer; default value
		}
		else {
			//Personalized header
			this.setPersonalizedHeader();
			String navigationString = "Create account";
			this.getContent().getNavigationObject().setToString(navigationString);
			//Footer: No need to set the footer; default value
			
		}
		
		
	
	}
	
	private static String tabFormating(ArrayList<String> strings) {
		String formated_elements="\t"; //$NON-NLS-1$
		for(String elem:strings) {
			formated_elements +=elem+"\t\t"; //$NON-NLS-1$
		}
		return formated_elements+"\n"; //$NON-NLS-1$
		
	}
	
}
