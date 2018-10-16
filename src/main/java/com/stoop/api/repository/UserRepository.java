package com.stoop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoop.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUser(String user);
	
	
	
}
