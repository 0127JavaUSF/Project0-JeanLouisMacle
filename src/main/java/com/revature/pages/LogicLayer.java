package com.revature.pages;

import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;

import com.revature.db.Account;
import com.revature.db.AccountDAO;
import com.revature.db.UserProfile;
import com.revature.db.UserProfileDAO;

/**
 * This class handles the data received by the user and sends back data to be displayed.  
 * */
public class LogicLayer {
	
	/* if userEntry is a valid number option, the Page to display is retrieved from the navigationMenu object */	
	public Page answerUserRequest(Page pageDisplayed, String userData)
	{
		System.out.println("Page title: "+pageDisplayed.getTitle());
		System.out.println("User data: "+userData);
		if (pageDisplayed.expectsIntOnlyAsEntry()) {System.out.println("Only ints are expected in value");}
			else {System.out.println("Strings non parsable as int are expected as value");}
		
		Page pageToReturn = null;
		//The data entered is tested to see if the options are outside what would be expected
		//Either an int is expected as an entry, or a string
		NavigationMenu navigationObject = pageDisplayed.getContent().getNavigationObject();
		ArrayList<Page> listOfPageObjects = navigationObject.getNavigationMenuPages();
		
		//Special case
		if(pageDisplayed.getClass() == AddWithdrawMoneyPage.class) {//treated as a string ould be treated (username, password)
			pageDisplayed.getContent().getUnknowEntryMessage().setUserData(null);
			pageToReturn = this.nextPageToReturnAfterStringEntry(pageDisplayed, userData);
			this.setPageData(pageToReturn);
			return pageToReturn;
			}
		
		/* Parsing to distinguish int from non int */			
		int parsedEntryInt = -1;
		try {
			parsedEntryInt = Integer.parseInt(userData);
			//test if we are in the range of the expected menu options
			System.out.println("listOfPageObjects.size():"+listOfPageObjects.size());
			int maxIntValueExpected = listOfPageObjects.size();
			if (1<= parsedEntryInt && parsedEntryInt <= maxIntValueExpected) {
				System.out.println("User data is inside the range of expected answer.Parsed value:"+parsedEntryInt+". Number of options:"+listOfPageObjects.size());
				Page.lastIntEntry = parsedEntryInt;
				System.out.println("Page displayed:"+pageDisplayed.getClass());
				//Resetting UnknowEntryMessage
				pageDisplayed.getContent().getUnknowEntryMessage().setUserData(null);
				//The user data is inside the range of expected answer
				ArrayList<Page> pagesInNavigationMenu = pageDisplayed.getContent().getNavigationObject().getNavigationMenuPages();
				pageToReturn = pagesInNavigationMenu.get(parsedEntryInt-1);
				
				
			}
			else {
				//or the user data is outside the range of expected answer
				System.out.println("User data is outside the range of expected answer.");
				pageDisplayed.getContent().getUnknowEntryMessage().setUserData(userData);
				pageToReturn = pageDisplayed;						
			}
			System.out.println("Page to return: "+pageToReturn.getClass());
			this.setPageData(pageToReturn);
			return pageToReturn;
		}
		catch(NumberFormatException e) {
			//The entry was not an int; Were all entries expected to be ints
			if (pageDisplayed.expectsIntOnlyAsEntry()) {
				System.out.println("The program tried to parse what is not an int.");
				pageDisplayed.getContent().getUnknowEntryMessage().setUserData(userData);
				pageToReturn = pageDisplayed;	
				this.setPageData(pageToReturn);
				return pageToReturn;
			}
			else { //this a String entry, potentially a user name or a password
				pageDisplayed.getContent().getUnknowEntryMessage().setUserData(null);
				pageToReturn = this.nextPageToReturnAfterStringEntry(pageDisplayed, userData);
				this.setPageData(pageToReturn);
				return pageToReturn;
			}
			
			
			
		}
			
	
		
	}
	
	private static boolean isUserNameValid(String userData) {
		//TODO call to DB
		return true;
	}
	
	private static boolean isPasswordValid(String userData) {
		//TODO call to DB
		
		
		//Password is valid
		//TODO retrieve the id from the db
		int clientId = 1; 
		LogicLayer.retrieveClientInfo(clientId);		
		
		//TODO finish the isPasswordValid
		return true;
	}
	
	public static void retrieveClientInfo(int clientId) {
		//Loading data from the database
		//Retrieving the profile from the database
		UserProfileDAO profileDao = new UserProfileDAO();	
		//TODO retrieve id from username/password data
		UserProfile userProfile = profileDao.getProfile(clientId);
		Page.setUserProfile(userProfile);
		//Retrieving the account information 
		AccountDAO dao = new AccountDAO();
		dao.retrieveAccountLists(clientId);
				
		
	}
	
	
	private static boolean isPasswordStrentgthAcceptable(String userData) {
		//TODO
		return true;
	}
	
	
	private Page nextPageToReturnAfterStringEntry(Page pageDisplayed, String userData)
	{
		
		if (pageDisplayed.getClass() == LoginPage.class)
		{
			if(((LoginPage)pageDisplayed).isUserNameEntryPage()){
			
				//a valid/invalid user name or a valid/invalid password has been entered
				if(isUserNameValid(userData)) 
				{//return Login Page with content message asking for password
					System.out.println("User name verification bypassed. Login page to ask for password.");
					pageDisplayed.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("LoginPage.message.enterPassword"));
					((LoginPage)pageDisplayed).setIsUserNameEntryPage(false);
					System.out.println("Value of new content message text is: "+pageDisplayed.getContent().getContentMessage().getContentMessageText());
					return pageDisplayed;
				}
				else
				{//return Login Page with error message
					pageDisplayed.getContent().getUnknowEntryMessage().setUserData(userData);
					return pageDisplayed;
				}
			}
			else
			{
				if(isPasswordValid(userData))
				{
					//Return Accounts home page
					return AccountsHomePage.returnSingleton();
				}
				else 
				{//return Login Page with error message
					pageDisplayed.getContent().getUnknowEntryMessage().setUserData(userData);
					return pageDisplayed;
				}
			}			
		}
		else if (pageDisplayed.getClass() == RegistrationPage.class)
		{
			if(((RegistrationPage)pageDisplayed).isUserNameEntryPage()){
				if(isPasswordStrentgthAcceptable(userData)) {
					//TODO: store user name in DB
					
					//Return Registration Page asking for password
					System.out.println("Setting registration message asking for a password.");
					((RegistrationPage)pageDisplayed).setIsUserNameEntryPage(false);
					pageDisplayed.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("RegistrationPage.message.password"));
					return pageDisplayed;
				}
				else
				{
					//TODO Return the same page with a message asking for a stronger password.
					
				}
				
				
				
			}
			else
			{
				//TODO: store password hash in DB
				
				//Registration is done. Logging page to be displayed.
				return LoginPage.returnSingleton();
				
				
			}
			
				
				
			}
		else if (pageDisplayed.getClass() == AddWithdrawMoneyPage.class)
		{
			if (userData.equals("*")) {return AccountsHomePage.returnSingleton();}
			else if (NumberUtils.isCreatable(userData))//TODO parse for numeric value
			{
				Float userDataToNumeric = new Float(userData);
				Account currentAccount = Page.getCurrentAccount(Page.lastIntEntry);
				Float previousBalance = currentAccount.getBalance();
				Float newBalance = previousBalance + userDataToNumeric;
				currentAccount.setBalance(newBalance);
				
				return AccountPage.returnSingleton();
			}
			else //unknown entry
			{
				pageDisplayed.getContent().getUnknowEntryMessage().setUserData(userData);
				return pageDisplayed;
			}
		
		}
		
		
		return null;
	}
	/* the LogicLayer updates the data in the pages. */
	private void setPageData(Page pageToReturn) {
		/*Updating the data for the Home Page*/
		if(pageToReturn.getClass() == HomePage.class) 
			{	// The home page navigation menu list is added only if not yet existing (ArrayList is empty)
				// In some cases, like the Account Menu Page, the Navigation Menu will have to be modified if an account has been created.
				if (((HomePage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().size()==0)
						((HomePage)pageToReturn).setNavigationMenuObjects();
				//Creating the string to display to the user
				((HomePage)pageToReturn).setPageToString();
			}
		
		/*Updating the data for the Login Page*/
		else if (pageToReturn.getClass() == LoginPage.class)
			{	
				if (((LoginPage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().size()==0)
					((LoginPage)pageToReturn).setNavigationMenu();
				((LoginPage)pageToReturn).setPageToString();
			}
		
		/*Updating the data for the Registration Page*/
		else if (pageToReturn.getClass() == RegistrationPage.class) 
		{
			if (((RegistrationPage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().size()==0)
				((RegistrationPage)pageToReturn).setNavigationMenu();
			((RegistrationPage)pageToReturn).setPageToString();
		}
			
		/* Updating the data for the Accounts Home Page*/
		else if (pageToReturn.getClass() == AccountsHomePage.class)
		{			
			//The navigation menu for the Accounts Menu Page can change when accounts are added/closed.
			// A new navigation menu is re-created each time to take into account adding/closing accounts
			((AccountsHomePage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().clear();
			//
			//if (((AccountsHomePage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().size()==0)
			//((AccountsHomePage)pageToReturn).setNavigationMenu();
			
			((AccountsHomePage)pageToReturn).setPageToString();
		}
		else if (pageToReturn.getClass() == AccountPage.class)
		{			
			
			((AccountPage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().clear();
			
			((AccountPage)pageToReturn).setPageToString();
		}
		else if (pageToReturn.getClass() == AccountManagementPage.class)
		{			
			
			((AccountManagementPage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().clear();
			
			((AccountManagementPage)pageToReturn).setPageToString();
		}
		else if (pageToReturn.getClass() == AddWithdrawMoneyPage.class)
		{			
			
			((AddWithdrawMoneyPage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().clear();
			
			((AddWithdrawMoneyPage)pageToReturn).setPageToString();
		}
		else if (pageToReturn.getClass() == TransferMoneyPage.class)
		{			
			
			((TransferMoneyPage)pageToReturn).getContent().getNavigationObject().getNavigationMenuPages().clear();
			
			((TransferMoneyPage)pageToReturn).setPageToString();
		}
		
		
	}
	
	

}
