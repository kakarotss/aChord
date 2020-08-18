package com.qa.achord.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public List <courses> allCourses(@RequestBody users user) {
		return courseService.getCourses(user);
	}
	
	
	@PostMapping("/idCourses")
	public Optional<courses> idCourse(@RequestBody courses course) {
		Optional<courses> myCourse = Optional.empty();
		myCourse = courseService.idCourses(course);
		return myCourse;
	}
	
	///////////////////////Admin tools Controller methods/////////////////
	


}
