package com.qa.achord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.achord.entity.users;

@Repository
public interface usersRepo extends JpaRepository<users, Integer> {
	
	public List<users> findByUsername(String name);
	
	@Query(value= "SELECT * FROM users WHERE username=?1 AND user_password=?2", nativeQuery=true)
	public List<users> login(String username, String password);

}
