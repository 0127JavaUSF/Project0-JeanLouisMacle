package com.revature.pages;

public class UnexpectedEntryMessage {
	
	private String userData;
	private String errorMessagePart1 = "\nYour entry did not correspond to one of the choices.\nPlease review your entry and the available options:*";
	private String errorMessagePart2 = "*\nNote:  2 * characters delimit your entry.\n";
	
	
	
	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}
	
	public String toString() {
		if (userData != null) return errorMessagePart1+userData+errorMessagePart2;	
		else return "";
	}

}
