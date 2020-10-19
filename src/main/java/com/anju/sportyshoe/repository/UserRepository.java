package com.anju.sportyshoe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anju.sportyshoe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByuname(String uname);
	
	public List <User> findByisAdmin(boolean isAdmin);
}
