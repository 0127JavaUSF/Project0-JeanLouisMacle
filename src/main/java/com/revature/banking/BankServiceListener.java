package com.revature.banking;
//TODO  Probably a Thread based code allowing to continuously be able to read input from the console. A listener, that never stops, and read all inputs from the bank console. The listener starts on the main page and keeps in memory the page the user is on. After having received the user input, a request is sent to the logic layer to get the next data to display. --> 2 parameters: page_name + option chosen by the user.
public class BankServiceListener implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("The Thread is running");
		
	}
	
	public static void main(String[] args) {
		BankServiceListener myBankServiceListener = new BankServiceListener();
		Thread myThread = new Thread(myBankServiceListener);
		
	}
	

}
