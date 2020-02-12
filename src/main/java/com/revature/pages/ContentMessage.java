package com.revature.pages;

public class ContentMessage {
	private String text;
	
	public String getContentMessageText() {
			return text;
		}

	public void setContentMessageText(String message) {
		this.text = message;
	}

	public String toString() {	
		if (this.getContentMessageText()!=null) return this.getContentMessageText();
		else return "";
	}

}
