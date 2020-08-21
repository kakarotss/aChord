package com.qa.achord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.achord.entity.users;
import com.qa.achord.repository.usersRepo;

@Service
public class adminUserService {
	
	@Autowired
	usersRepo userRepo;
	
	String message = "unknown";
	
	public List<users> adminGetUsers() {
		List <users> allUsers = userRepo.findAll();
	
		return allUsers;
	}

	
	public String adminAddUser(users user) {
		userRepo.save(user);
		
		if(userRepo.findByUsername(user.getUsername()).isEmpty()) {
			message = "Insert failed, please try again";
		}
		else {
			message = user.getUsername()+" Inserted";
		}
		//need check if it actually has been inserted probably using optional
		return message;
	}
	
	
	


public String adminDeleteAccount(int id) {
	
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
