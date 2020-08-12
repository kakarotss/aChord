package com.qa.achord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.achord.entity.courses;
import com.qa.achord.entity.users;

@Repository
public interface coursesRepo extends JpaRepository<courses, Integer> {
	
	@Query(value= "select * from courses where course_id NOT IN (select course_course_id from course_line where user_user_id = ?1);", nativeQuery=true)
	public List<courses> getLoggedInCourses(int id);
	
	
}
