package com.qa.achord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.achord.entity.users;
import com.qa.achord.service.usersService;
import com.qa.achord.service.adminUserService;

@CrossOrigin   //need this line just need it dont ask
@RestController
@RequestMapping("/aChord")
public class usersController {
	
	@Autowired
	usersService userService;
	
	@Autowired
	adminUserService adminUserService;
	
	@PostMapping("/Register")
	public String registration(@RequestBody users user) {
		userService.register(user);
		return "User registered: "+ user.getUsername();
		
	}
	
	@PostMapping("/Login")
	public List <users> signin(@RequestBody users user) {
		return userService.login(user);	
	}
	
	@GetMapping("/myProfile")
	public List<users> myProfile(@RequestBody users user) {
		return userService.myProfile(user);
	}
	
	@DeleteMapping("/deleteMyAccount")
	public String deleteMyProfile(@RequestBody users user) {
		return userService.deleteAccount(user.getUserId());
	}
	
	
	///////////////////////Admin tools Controller methods/////////////////
	
	@GetMapping("/allUsers")
	public List<users> getAll() {
		return adminUserService.adminGetUsers();
	}
	
	@PostMapping("/addUsers")
	public String adminAdd(@RequestBody users user) {
		return adminUserService.adminAddUser(user);
		
	}
	
	@DeleteMapping("/deleteAccount")
	public String deleteProfile(@RequestBody users user) {
		return adminUserService.adminDeleteAccount(user.getUserId());
	}

}
