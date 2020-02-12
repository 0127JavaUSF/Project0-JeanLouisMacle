package com.revature.db;

public class UserProfile {
	private int clientId;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	
	public UserProfile(int clientId,String firstName, String lastName, String email, String username) {
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = username;
		this.email = email;
		
	}
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
