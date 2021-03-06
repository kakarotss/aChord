package com.qa.achord.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.achord.entity.chords;
import com.qa.achord.entity.courses;
import com.qa.achord.entity.users;
import com.qa.achord.repository.chordsRepo;
import com.qa.achord.repository.coursesRepo;
import com.qa.achord.repository.usersRepo;

@Service
public class chordsService {
	
	@Autowired
	chordsRepo chordRepo;
	
	
	String message = "unknown";
	
	public List <chords> getAllChords() {
		
		return chordRepo.findAll();
	}
	
public List <chords> getCourseChords(int Cid,int Uid) {
		
		return chordRepo.CourseChords(Cid, Uid);
	}

public List <chords> getCourseChordsOffline(int Cid) {
	
	return chordRepo.CourseChordsOffline(Cid);
}


public List <chords> search(String search) {
	
	return chordRepo.search(search);
}
	
	
	
	

}
