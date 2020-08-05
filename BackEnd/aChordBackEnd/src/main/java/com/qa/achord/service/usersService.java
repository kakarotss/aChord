package com.qa.achord.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.achord.entity.users;
import com.qa.achord.repository.usersRepo;

@Service
public class usersService {
	
	@Autowired
	usersRepo userRepo;
	
	public String register(users user) {
		
		//need check if it actually has been inserted probably using optional
		return ""+userRepo.save(user);
	}
	
	

}
