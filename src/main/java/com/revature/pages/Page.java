package com.revature.pages;

import java.util.ArrayList;
import java.util.HashMap;

import com.revature.db.Account;
import com.revature.db.UserProfile;

public class Page {
	/* All pages where the user is not logged in have the same header, defined in the Header class.*/
	private Header theHeader = new Header();
	private Content theContent = new Content();
	private Footer theFooter = new Footer();	
	
	private String title ="";
	private String navigationMenuText ="";
	
	boolean expectsIntOnlyAsEntry;	
	static String pressReturnKeyText = StringExternalizationUtility.getString("Page.typeReturn"); //$NON-NLS-1$
	
	/* The Pages objects contain the UserProfile object and Account object(s)*/
	private static UserProfile userProfile = null;
	private static ArrayList<Account> checkingAccountList = null;
	private static ArrayList<Account> savingAccountList = null;
	static int lastIntEntry;
	
	public static String username;
	public static String temporaryUserName;
	public static String password;
	public static int clientId;
	
	public static UserProfile getUserProfile() {
		return userProfile;
	}

	public static void setUserProfile(UserProfile userProfile) {
		Page.userProfile = userProfile;
	}

	public static ArrayList<Account> getCheckingAccountList() {
		return checkingAccountList;
	}

	public static void setCheckingAccountList(ArrayList<Account> accountList) {
		Page.checkingAccountList = accountList;
	}	
	
	public static ArrayList<Account> getSavingAccountList() {
		return savingAccountList;
	}

	public static void setSavingAccountList(ArrayList<Account> savingAccountList) {
		Page.savingAccountList = savingAccountList;
	}
	
	public boolean expectsIntOnlyAsEntry() {
		return expectsIntOnlyAsEntry;
	}

	public void setExpectsIntOnlyAsEntry(boolean expectsIntOnlyAsEntry) {
		this.expectsIntOnlyAsEntry = expectsIntOnlyAsEntry;
	}
	

	public String getTitle() {
		return title;
	}
		
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNavigationMenuText() {
		return navigationMenuText;
	} 
	
	public void setNavigationMenuText(String navigationMenuText) {
		this.navigationMenuText =  navigationMenuText;
	} 
	
	public Header getHeader() {
		return theHeader;
	}
	public void setHeader(Header theHeader) {
		this.theHeader = theHeader;
	}
	public Content getContent() {
		return theContent;
	}
	public void setContent(Content theContent) {
		this.theContent = theContent;
	}
	public Footer getFooter() {
		return theFooter;
	}
	public void setFooter(Footer theFooter) {
		this.theFooter = theFooter;
	}
	
	public void setStaticNavigationMenuToString()
	{
		String navigationString="";
		int menuNumber = 1;
		//Using an enhanced for
		ArrayList<Page> pagesLinkedToMenu = this.getContent().getNavigationObject().getNavigationMenuPages();
		for (Page aPageOfMenu : pagesLinkedToMenu) {
			navigationString += aPageOfMenu.getNavigationMenuText()+menuNumber+Page.pressReturnKeyText+'\n';		
			menuNumber++;
		}
		this.getContent().getNavigationObject().setToString(navigationString);
	}
	
	public void setPersonalizedHeader(){
		//Set the Header, with access to user profile data				
			String firstName;
			try {
				firstName= Page.getUserProfile().getFirstName();
				this.getHeader().setHeader(Header.title+", "+firstName); //$NON-NLS-1$
			}
			catch (NullPointerException e) {
				System.err.println("The UserProfile object has a null value."); //$NON-NLS-1$
			}
		}
	
	public static Account getCurrentAccount(int lastIntEntry) {
		ArrayList<Account> checkingAccountList = Page.getCheckingAccountList();
		ArrayList<Account> savingsAccountList = Page.getSavingAccountList();
		Account currentAccount;
		if (lastIntEntry<= checkingAccountList.size()) currentAccount=checkingAccountList.get(lastIntEntry-1);
		else currentAccount = savingsAccountList.get(lastIntEntry - checkingAccountList.size() -1 );
		return currentAccount;
	}
	
//	/* Mockup data*/
//	public void setMockupData() {
//		Account account1C = new Account(1,1,"1234",1454);		
//		
//		Account account1S = new Account(1,2,"2112",1474);		
//		
//		ArrayList<Account> checkingAccountList = new ArrayList();
//		ArrayList<Account>savingAccountList = new ArrayList();
//		checkingAccountList.add(account1C);
//		this.setCheckingAccountList(checkingAccountList);
//		savingAccountList.add(account1S);
//		this.setSavingAccountList(savingAccountList);
//		
//		UserProfile profile = new UserProfile();
//		profile.setFirstName("John");
//		profile.setLastName("Appleseed");
//		profile.setUserName("JApple");
//		profile.setEmail("j@appleseed.com");
//		this.setUserProfile(profile);
//		
//	}
	

}
