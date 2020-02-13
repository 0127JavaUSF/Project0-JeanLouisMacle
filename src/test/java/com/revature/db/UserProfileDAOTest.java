package com.revature.db;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pages.Page;

public class UserProfileDAOTest {
	UserProfileDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new UserProfileDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void getProfileTest() {
//		dao.getProfile(1);
//		assertTrue(Page.getUserProfile() != null);		
//	}
//	
//	@Test
//	public void setUserName() {			
//		assertTrue(dao.setUserName("testDao3") ==1);//returns the row count
//	}
	
	@Test 
	public void getClientIdFromPassword() {
		//assertTrue(dao.getClientIdFromPasswordAndHash("test2","$2a$06$wGebSSqNAS22VMjuHp22Ie8Uy36LCpM7A2p2jKpyuXCgMVb34Vxz2")==2);
		assertTrue(dao.getClientIdFromPasswordAndHash("test1","$2a$06$YFwZAKFDai3QZBDnqqgzMO8oE6b2QS03gXVb0kg4pLVzSWte.PUEq")==1);
	}

}
