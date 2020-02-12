package com.revature.pages;

public class Content {
	
	NavigationMenu navigationMenu = new NavigationMenu();
	ContentMessage navigationMessage = new ContentMessage();
	UnexpectedEntryMessage unknowEntryMessage = new UnexpectedEntryMessage();
	
	
	public NavigationMenu getNavigationObject() {
		return navigationMenu;
	}
	public void setNavigationObject(NavigationMenu navigationMenu) {
		this.navigationMenu = navigationMenu;
	}
	public ContentMessage getContentMessage() {
		return navigationMessage;
	}
	public void setContentnMessage(ContentMessage navigationMessage) {
		this.navigationMessage = navigationMessage;
	}
	public UnexpectedEntryMessage getUnknowEntryMessage() {
		return unknowEntryMessage;
	}
	public void setUnknowEntryMessage(UnexpectedEntryMessage unknowEntryMessage) {
		this.unknowEntryMessage = unknowEntryMessage;
	}
	
	
	
	
	
	
	
	

}
