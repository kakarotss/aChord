package com.qa.achord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.achord.entity.users;
import com.qa.achord.service.usersService;

@CrossOrigin   //need this line just need it dont ask
@RestController
@RequestMapping("/aChord")
public class usersController {
	
	@Autowired
	usersService userService;
	
	@PostMapping("/Register")
	public String insertForm(@RequestBody users user) {
		
		userService.register(user);
		return "User registered: "+ user.getUsername();
		
	}

}
