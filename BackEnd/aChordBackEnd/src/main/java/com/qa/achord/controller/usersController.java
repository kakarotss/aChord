package com.qa.achord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String registration(@RequestBody users user) {
		
		userService.register(user);
		return "User registered: "+ user.getUsername();
		
	}
	
	@PostMapping("/Login")
	public String signin(@RequestBody users user) {
		
		
		return "Status: "+ userService.login(user);	
	}
	
	@GetMapping("/myProfile")
	public List<users> myProfile(@RequestBody users user) {
		return userService.myProfile(user);
	}

}
