package com.revature.db;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CredentialsDAOTest {
	
	CredentialsDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new CredentialsDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void retrieveCredentialsTest() {
		System.out.println(dao.retrieveCredentials("JohnAppleseed"));		
		assertEquals(1,dao.retrieveCredentials("JohnAppleseed"));
	}

}
