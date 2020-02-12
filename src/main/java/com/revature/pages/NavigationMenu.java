package com.revature.pages;

import java.util.ArrayList;

public class NavigationMenu{
	
	/* Need of an ordered structure for the pages related to the navigation menu. */
	ArrayList<Page> navigationMenuPages = new ArrayList<Page>();
	private String stringToReturn = null;
	
	
	public ArrayList<Page> getNavigationMenuPages() {
		return navigationMenuPages;
	}

	public void setToString(String toStringContent) {
		this.stringToReturn = toStringContent;
	}

	public String toString() {			
		return stringToReturn;
	}
	

}
