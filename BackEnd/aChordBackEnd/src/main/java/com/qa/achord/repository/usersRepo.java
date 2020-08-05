package com.qa.achord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.achord.entity.users;

@Repository
public interface usersRepo extends JpaRepository<users, Integer> {

}
