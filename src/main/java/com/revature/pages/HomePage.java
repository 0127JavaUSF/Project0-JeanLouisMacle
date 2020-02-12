package com.revature.pages;

import java.util.ArrayList;

public class HomePage extends Page {
	//singleton
	private static HomePage theOnlyHomePage;
	
	NavigationMenu navigationObject;	
	
	private HomePage() {
		this.setTitle(StringExternalizationUtility.getString("HomePage.pageTitle"));	
		//Invitation text to choose to navigate toward the home page
		this.setNavigationMenuText(StringExternalizationUtility.getString("HomePage.navigationMenuText"));		
		//Type of entry expected
		/* boolean defining if only int values are expected in entry */
		this.setExpectsIntOnlyAsEntry(true);
	}
	
	public static HomePage returnSingleton() {
		if (theOnlyHomePage==null) {theOnlyHomePage = new HomePage();}
		return theOnlyHomePage;		
	}
	
	public void setNavigationMenuObjects() {
		//Navigation object 
		navigationObject  = this.getContent().getNavigationObject();		
		/* Adding the LoginPage and the RegistrationPage objects to the navigation menu */		
		navigationObject.getNavigationMenuPages().add(LoginPage.returnSingleton());
		navigationObject.getNavigationMenuPages().add(RegistrationPage.returnSingleton());
	}
	
	/* this method   */
	public void setPageToString() {
		//Header: No need to set the header; default value
		
		//Content
			//Navigation menu
		this.setStaticNavigationMenuToString();
			//The message part is left to its default value
			//The unknown entry part is left to its default value
		
		//Footer: No need to set the footer; default value
		
		
	}
}
	


	
		



