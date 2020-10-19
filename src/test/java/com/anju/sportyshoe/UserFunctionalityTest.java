package com.anju.sportyshoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import com.anju.sportyshoe.controller.UserController;
import com.anju.sportyshoe.model.User;

@DisplayName("User Functionality Tests")
@SpringBootTest
class UserFunctionalityTest {

	@Autowired
	private UserController userCtrl;
	@Autowired
	MockHttpSession session;
	
	
	@Test
	@DisplayName("User Controller Availability Test")
	void testUserrepo() {
		assertThat(userCtrl).isNotNull();
	}
	
	@Test
	@DisplayName("User Registration Test")
	void testUserRegistration() {		
		User user = new User();
		user.setUname("TestUser5");
		user.setPassword("123456");
		user.setIsAdmin(true);
		User createdUser = userCtrl.UserRegistration(user);
		assertNotNull(createdUser);
	}
	
	@Test
	@DisplayName("User Login Test")
	void testUserLogin() {
		User user = new User();
		user.setUname("VijayAntony");
		user.setPassword("123456");
		
		User loggedInUser = userCtrl.UserLogin(user, session);
		assertNotNull(loggedInUser);
	}
	
	@Test
	@DisplayName("Change Password Test")
	void testChangePassword() {
		User user = new User();
		user.setPassword("654321");
		
		User loggedInUser = userCtrl.changePassword(user, session);
		assertNotNull(loggedInUser);
	}
	
	@Test
	@DisplayName("List All Logged-in User Test")
	void testListUser() {
		List <User> userList = userCtrl.listUser();
		assertEquals(5, userList.size());
	}
	
	@Test
	@DisplayName("Find A User by UserName")
	void testGetUserByUserName() {
		User user = userCtrl.listUser("VijayAntony");
		assertThat(user).isNotNull();
	}
}
