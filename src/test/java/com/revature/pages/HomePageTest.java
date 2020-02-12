package com.revature.pages;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomePageTest {
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/* Testing that Login Page and Registration Page are inside the navigation menu ArrayList */
	public void testLoginFirstInMenu() {
		HomePage aHomePage = HomePage.returnSingleton();
		ArrayList<Page> menuPages = aHomePage.getContent().getNavigationObject().getNavigationMenuPages();
		assertTrue(((Page)menuPages.get(0)).getClass()==LoginPage.class && ((Page)menuPages.get(1)).getClass() == RegistrationPage.class );
	}

}
