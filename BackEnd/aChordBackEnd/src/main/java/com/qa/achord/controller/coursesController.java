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

import com.qa.achord.entity.courses;
import com.qa.achord.entity.users;
import com.qa.achord.service.usersService;
import com.qa.achord.service.adminUserService;
import com.qa.achord.service.coursesService;

@CrossOrigin   //need this line just need it dont ask
@RestController
@RequestMapping("/aChord")
public class coursesController {
	
	@Autowired
	coursesService courseService;
	
	
	@PostMapping("/allCourses")
	public List <courses> registration(@RequestBody users user) {
		
		return courseService.getCourses(user);
		
	}
	
//	@PostMapping("/Login")
//	public List <users> signin(@RequestBody users user) {
//		return userService.login(user);	
//	}
//	
//	@PostMapping("/myProfile")
//	public List<users> myProfile(@RequestBody users user) {
//		return userService.myProfile(user);
//	}
//	
//	@DeleteMapping("/deleteMyAccount")
//	public String deleteMyProfile(@RequestBody users user) {
//		return userService.deleteAccount(user.getUserId());
//	}
//	
	
	///////////////////////Admin tools Controller methods/////////////////
	


}
