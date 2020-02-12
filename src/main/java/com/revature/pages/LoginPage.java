package com.revature.pages;

public class LoginPage extends Page {
	private static LoginPage theOnlyLoginPage;
	private  boolean isUserNameEntryPage = true;
	
	NavigationMenu navigationObject;	
	
	
	private LoginPage() {
		this.setTitle(StringExternalizationUtility.getString("LoginPage.pageTitle"));
		//Invitation text to choose to navigate toward the registration page
		this.setNavigationMenuText(StringExternalizationUtility.getString("LoginPage.navigationMenuText"));
		this.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("LoginPage.message.enterUserName")+Page.pressReturnKeyText);
		
		
		//Type of entry expected
		/* boolean defining if only int values are expected in entry */
		this.setExpectsIntOnlyAsEntry(false);		
	}
	
	public static LoginPage returnSingleton() {
		if (theOnlyLoginPage ==null) theOnlyLoginPage = new LoginPage();
		return theOnlyLoginPage;
	}
	
	public boolean isUserNameEntryPage() {
		return isUserNameEntryPage;
	}

	public void setIsUserNameEntryPage(boolean isUserNameEntryPage) {
		this.isUserNameEntryPage = isUserNameEntryPage;
	}
	
	
	public void setNavigationMenu() {
		//Navigation object
		navigationObject  = this.getContent().getNavigationObject();
		/* Adding the home page and the registration page to the main menu */
		navigationObject.getNavigationMenuPages().add(HomePage.returnSingleton());
		navigationObject.getNavigationMenuPages().add(RegistrationPage.returnSingleton());
		
	}
			
	public void setPageToString() {
		//Header: No need to set the header; default value
		
		//Content
		this.setStaticNavigationMenuToString();
		//The message part is modified
		if (isUserNameEntryPage) this.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("LoginPage.message.enterUserName"));
		else this.getContent().getContentMessage().setContentMessageText(StringExternalizationUtility.getString("LoginPage.message.enterPassword"));
		
			//The unknown entry part is left to its default value
		
		//Footer: No need to set the footer; default value
		
	}

}
	
