package com.revature.userInterface;

import java.io.Console;
import java.util.Scanner;

public class BankConsole implements UserInterface {
	
	private Scanner myScanner;	
	

	public  BankConsole()
	{
		myScanner = new Scanner(System.in);
		
	}
	
	public String readFromUser() {
		String userData="";
		try {
			userData = myScanner.nextLine();
		}
		catch (NullPointerException e) {
			System.err.println("Null pointer exception for the myScanner object");
		}
		return userData;
	}

	
	public String sendToLogicLayer(String userData) {
		// FIXME the parameter must also include a page id when the user input is sent to the logic layer.
		return null;
	}
	
	/* Test driven development: how to test that a display is successful ?*/
	public void displayToUser(String dataReceivedFromLogicLayer) {
		
		
	}

}
