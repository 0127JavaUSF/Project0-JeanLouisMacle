package com.revature.pages;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.db.Account;
import com.revature.db.UserProfile;

public class LogicLayerTest {
	LogicLayer logicLayer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		logicLayer = new LogicLayer();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void retrieveClientInfoTest() {
		LogicLayer.retrieveClientInfo(1);
		//test the UserProfile is not null;
		UserProfile profile = Page.getUserProfile();
		//test the checkingAccountList is not null;
		ArrayList<Account> checkingAccountList = Page.getCheckingAccountList();
		//test the savingsAccountList is not null;
		ArrayList<Account> savingsAccountList = Page.getSavingAccountList();
		
		boolean isProfileNotNull = (profile !=null);
		boolean isCheckingAccountListNotNull = (checkingAccountList != null);
		boolean isSavingsAccountListNotNull = (savingsAccountList != null);
		assertTrue(isProfileNotNull & isCheckingAccountListNotNull & isSavingsAccountListNotNull);
	};

	@Test
	public void isUserNameValidTest()
	{
		assertTrue(LogicLayer.isUserNameValid("JohnAppleseed"));		
	}
	
	
	
	
}
