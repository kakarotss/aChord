package com.qa.achord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.achord.entity.chords;
import com.qa.achord.entity.courseLine;
import com.qa.achord.entity.courses;

@Repository
public interface courseLineRepo extends JpaRepository<courseLine, Integer> {
		
	
	@Query(value= "select * from course_line where user_id= ?1", nativeQuery=true)
	public List<courseLine> myLine(int userId);
	

	//not working
//	@Query(value= "insert into course_line(course_status, course_id, user_id) values ('undone', ?1, ?2 )", nativeQuery=true)
//	public List<courseLine> addLine(int courseId, int userId);
//	
	
	
	

}
