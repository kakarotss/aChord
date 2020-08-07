package com.qa.achord.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.achord.entity.users;
import com.qa.achord.repository.usersRepo;

@Service
public class usersService {
	
	@Autowired
	usersRepo userRepo;
	
	String message = "unknown";
	
	public String register(users user) {
		userRepo.save(user);
		
		if(userRepo.findByUsername(user.getUsername()).isEmpty()) {
			message = "Registration failed, please try again";
		}
		else {
			message = user.getUsername()+" Registered";
		}
		//need check if it actually has been inserted probably using optional
		return message;
	}
	
	
	public List login(users user) {
		
		List <users> sommin = new ArrayList<users>();
		if(userRepo.login(user.getUsername(), user.getUserPassword()).isEmpty()) {
			message = "Incorrect username or password";
			
		}
		else {
			sommin = userRepo.login(user.getUsername(), user.getUserPassword());
			message = "Logged in";
			
			
		}
		System.out.println(message);
		
		return sommin;
	}
	
public List <users> myProfile(users user) {
		
		return userRepo.userProfile(user.getUsername());
	}

public String deleteAccount(int id) {
	
	 userRepo.deleteById(id);
	 
	 if(userRepo.existsById(id)) {
		 message = "Account deletion failed";
	 }
	 else {
		 message = "Account deleted successfully";
	 }
	return message;
}

	

}
