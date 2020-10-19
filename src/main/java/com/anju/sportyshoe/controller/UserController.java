package com.anju.sportyshoe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anju.sportyshoe.exception.DuplicateUserException;
import com.anju.sportyshoe.exception.InvalidLoginException;
import com.anju.sportyshoe.model.User;
import com.anju.sportyshoe.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/register")
	public User UserRegistration(@RequestBody User user) {
		User doesExist = this.userRepo.findByuname(user.getUname());
		
		/*if username already exists throw duplicate user exception*/
		if(doesExist != null) {
			throw new DuplicateUserException("User already exists");
		}else {
			return this.userRepo.save(user);
		}
	}
	
	@PostMapping("/login")
	public User UserLogin(@RequestBody User user, HttpSession session) {
		User doesExist = this.userRepo.findByuname(user.getUname());
		if(doesExist != null) {
			/*if login uname & password matches, allow login and keep session*/
			if(doesExist.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", doesExist);
				return doesExist;
			}else {
				throw new InvalidLoginException("Invalid Login Credential..");
			}
		}else throw new InvalidLoginException("Invalid Login Credential..");
	}
	
	@PutMapping("/save")
	public User changePassword(@RequestBody User user, HttpSession session) {
		User userInfo = (User) session.getAttribute("user");
		if(userInfo != null) {
			userInfo.setPassword(user.getPassword());
			session.setAttribute("user", userInfo);
			this.userRepo.save(userInfo);	
			return (User) session.getAttribute("user");
		}else {
			throw new InvalidLoginException("Please Login to the system..");
		}
	}
	
	@GetMapping("")
	public List <User> listUser(){		
		return this.userRepo.findByisAdmin(false);
	}
	
	@GetMapping("/{uname}")
	public User listUser(@PathVariable(name="uname")String uname){		
		return this.userRepo.findByuname(uname);
	}
		
}
