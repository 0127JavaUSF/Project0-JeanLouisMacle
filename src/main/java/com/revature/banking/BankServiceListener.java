package com.revature.banking;

import com.revature.pages.HomePage;
import com.revature.pages.Page;
import com.revature.userInterface.BankConsole;


public class BankServiceListener {
	
	static BankConsole myBankConsole = new BankConsole();
	static Page pageDisplayed = HomePage.returnSingleton();
	
	public static void main(String[] args) {
		
		/* The ATM home page is displayed when the program starts. 
		 * The navigation menu is set outside of the constructor to avoid recursivity issues. */	
		
		((HomePage)pageDisplayed).setNavigationMenuObjects();
		((HomePage)pageDisplayed).setPageToString();
		myBankConsole.displayToUser(pageDisplayed);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("InterruptedException raised when trying to put the thread to sleep.");
			e.printStackTrace();
		}
		
		/* After the home page is displayed, the listener waits for user input. */
		while(true) {
			String userData = myBankConsole.readFromUser();					
			Page pageToDisplay = myBankConsole.sendToLogicLayer(pageDisplayed, userData);//1: menu id
			myBankConsole.displayToUser(pageToDisplay);		
			pageDisplayed = pageToDisplay;
		}
		
	}
}
	
	
	


