package com.revature.userInterface;

public interface UserInterface {
	
	/**
	 * Returns A String that contains the data entered by the user in the user interface.
	 * @param None 
	 * @return The data entered by the user
	 */	
	public String readFromUser();
	
	/**
	 * Returns The data to be displayed on the user interface.
	 * @param  The data entered by the user
	 * @return The data to be displayed to the user
	 */		
	public String sendToLogicLayer(String userData);
	
	
	/**
	 * Returns Void
	 * @param  The results of the processing of the user data by the logic layer.
	 * @return Void
	 */
	public void displayToUser(String dataReceivedFromLogicLayer);
	

}
