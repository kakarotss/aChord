package com.qa.achord.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.achord.entity.courses;
import com.qa.achord.entity.users;
import com.qa.achord.repository.coursesRepo;
import com.qa.achord.repository.usersRepo;

@Service
public class coursesService {
	
	@Autowired
	coursesRepo courseRepo;
	
	
	String message = "unknown";
	
	public List <courses> getCourses(users user) {
		List <courses> courses = new ArrayList<courses>();
		
		if(user.getUserId() ==0) {
			
			courses  = courseRepo.findAll();
		}
		else {
			
			courses = courseRepo.getLoggedInCourses(user.getUserId());
			
			
		}
		//need check if it actually has been inserted probably using optional
		return courses;
	}
	
	
	
	

}
