package com.qa.achord.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class usersTest {
	
	private users user= new users();
	
	private users CompareUser;
	
	@Before
	public void createCompare() {
	 CompareUser = new users(1, "asd", "asd", "asd", "asd", "asd", 2);
	}
	
	@Test
	public void settersTest() {
		
		user.setEmail("asd");
		user.setFirstName("asd");
		user.setLastName("asd");
		user.setUserId(1);
		user.setUserLevel(2);
		user.setUsername("asd");
		user.setUserPassword("asd");
		
		assertEquals(CompareUser, user);
		
	}

}
