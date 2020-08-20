package com.qa.achord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.achord.entity.chords;

@Repository
public interface chordsRepo extends JpaRepository<chords, Integer> {
	
	
	@Query(value= "select * from chords where course_id= ?1 AND course_id not in (select course_id from course_line where user_id = ?2); ", nativeQuery=true)
	public List<chords> CourseChords(int courseId, int userId);
	
	@Query(value= "select * from chords where course_id= ?1", nativeQuery=true)
	public List<chords> CourseChordsOffline(int courseId);
	
	@Query(value= "select * from chords where chord_title LIKE %?1% OR chord_description LIKE %?1%", nativeQuery=true)
	public List<chords> search(String search);
	
	
	
	
	

}
