package com.qa.achord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.achord.entity.chords;

@Repository
public interface chordsRepo extends JpaRepository<chords, Integer> {
	
	
	@Query(value= "select * from chords where course_course_id= ?1", nativeQuery=true)
	public List<chords> CourseChords(int courseId);
	
	
	

}
