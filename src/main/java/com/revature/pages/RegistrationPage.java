package com.revature.pages;

public class RegistrationPage extends  Page{
	private static RegistrationPage theOnlyRegistrationPage;
	private  boolean isUserNameEntryPage = true;
	
	NavigationMenu navigationObject;
	
	
	private RegistrationPage() {
		this.setTitle(StringExternalizationUtility.getString("RegistrationPage.pageTitle"));	
		//Invitation text to choose to navigate toward the registration page
		this.setNavigationMenuText(StringExternalizationUtility.getString("RegistrationPage.navigationMenuText"));
		
		//Type of entry expected
		/* boolean defining if only int values are expected in entry */
		this.setExpectsIntOnlyAsEntry(false);

	}
	
	public static RegistrationPage returnSingleton() {
		if(theOnlyRegistrationPage == null) theOnlyRegistrationPage = new RegistrationPage();
		return theOnlyRegistrationPage;
	}
	
	public boolean isUserNameEntryPage() {
		return isUserNameEntryPage;
	}

	public void setIsUserNameEntryPage(boolean userNameEntryPage) {
		this.isUserNameEntryPage = userNameEntryPage;
	}
	
	public void setNavigationMenu() {
		//Navigation object
		navigationObject  = this.getContent().getNavigationObject();
		/* Adding the home page and the navigation page to the main menu */
		navigationObject.getNavigationMenuPages().add(HomePage.returnSingleton());
		navigationObject.getNavigationMenuPages().add(LoginPage.returnSingleton());		
		
	}
	
	public void setPageToString() {
		//Header: No need to set the header; default value
		
		//Content
		this.setStaticNavigationMenuToString();
			//The message part is modified
		if (isUserNameEntryPage) this.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("RegistrationPage.message.enterUserName"));
		else this.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("RegistrationPage.message.password"));
		
			//The unknown entry part is left to its default value
		
		//Footer: No need to set the footer; default value
		
	}

}
