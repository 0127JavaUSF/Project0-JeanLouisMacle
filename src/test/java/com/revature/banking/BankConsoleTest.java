/**
 * 
 */
package com.revature.banking;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.userInterface.BankConsole;

/**
 * @author 
 *
 */

import java.io.Console; 

/* Using the Mockito framework to pre-define some data used in the unit testing of the BankConsole class.  */
@RunWith(MockitoJUnitRunner.class)

public class BankConsoleTest {
	
	private BankConsole myBankConsole;
	@Mock
	LogicLayer myLogicLayer = new LogicLayer();
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myBankConsole = new BankConsole();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readFromUsertest() {
		
		System.out.println("In order to test the readFromUser method, Please copy and paste the following line in the console:");
		System.out.println("Test console entry.");
		String dataRead =  myBankConsole.readFromUser();
		assertEquals("Test console entry.", dataRead);
	}
	
	@Test
	public void sendToLogicLayerTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void displayToUserTest() {
		fail("Not yet implemented");
	}
	
	

}
