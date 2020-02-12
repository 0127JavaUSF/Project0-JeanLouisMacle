package com.revature.userInterface;

import java.util.Scanner;

import com.revature.pages.Page;
import com.revature.pages.LogicLayer;

public class BankConsole {
	
	private Scanner myScanner;	
	private LogicLayer myLogicLayer;
	

	public  BankConsole()
	{
		myScanner = new Scanner(System.in);
		myLogicLayer = new LogicLayer();
	}
	
	public String readFromUser() {
		String userData="";
		try {
			userData = myScanner.nextLine();
		}
		catch (NullPointerException e) {
			System.err.println("Null pointer exception for the myScanner object");
		}
		/* Here is the place to call upon the logic layer to treat the data received from the user.*/
		return userData;
	}

	
	public Page sendToLogicLayer(Page pageDisplayed, String userData) {
		Page pageToDisplay = myLogicLayer.answerUserRequest(pageDisplayed, userData);		
		return pageToDisplay;
	}
	
	/* Test driven development: how to test that a display is successful ?*/
	public void displayToUser(Page pageToDisplay) {
		/*Clearing console before printing new page*/
		//TODO Clear the console before printing
		
		
		/* Printing new page */
		System.out.println(pageToDisplay.getHeader().toString());
		System.out.println(pageToDisplay.getTitle()+'\n');
		System.out.println(pageToDisplay.getContent().getNavigationObject().toString());
		System.out.print(pageToDisplay.getContent().getContentMessage().toString());
		System.out.print(pageToDisplay.getContent().getUnknowEntryMessage().toString());
		System.out.println(pageToDisplay.getFooter().toString());
		
	}
	
}
