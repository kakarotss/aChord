package com.qa.achord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.achord.entity.chords;
import com.qa.achord.entity.courseLine;
import com.qa.achord.entity.courses;

@Repository
public interface chordsRepo extends JpaRepository<chords, Integer> {
	

}
