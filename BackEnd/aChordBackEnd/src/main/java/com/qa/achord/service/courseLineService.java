package com.qa.achord.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.achord.entity.courseLine;
import com.qa.achord.entity.courses;
import com.qa.achord.entity.users;
import com.qa.achord.repository.courseLineRepo;
import com.qa.achord.repository.coursesRepo;
import com.qa.achord.repository.usersRepo;

@Service
public class courseLineService {
	
	@Autowired
	courseLineRepo courseLineRepo;
	
	
	String message = "unknown";
	
	public List <courseLine> myCourseLine(users user) {
		
		return courseLineRepo.myLine(user.getUserId());
	}
	
	
public List <courseLine> insert(courseLine line) {
		courseLineRepo.save(line);
	
		return null;
	}

public List <courseLine> remove(courseLine line) {
	courseLineRepo.deleteById(line.getCourseLineId());

	return null;
}
	
	
	
	

}
