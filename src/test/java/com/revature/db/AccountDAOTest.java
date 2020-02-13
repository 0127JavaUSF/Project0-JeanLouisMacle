package com.revature.db;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pages.Page;

public class AccountDAOTest {
	AccountDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new AccountDAO();
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void retrieveAccountLists() {
		int clientId=1;
		dao.retrieveAccountLists(clientId);
		boolean checkingAccountListNotNull = ((Page.getCheckingAccountList()) != null);		
		boolean savingAccountListNotNull = (Page.getSavingAccountList() != null);
		System.out.println("checkingAccountListNotNull: "+checkingAccountListNotNull);
		System.out.println("savingAccountListNotNull: "+savingAccountListNotNull);
		assertTrue(checkingAccountListNotNull & savingAccountListNotNull);
		
	}

}
