package com.pss_lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pss_lab.controller.UserControler;
import com.pss_lab.model.User;

@RestController
public class UserService {
	
	@Autowired
	private UserControler userControler;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/users")
	@JsonIgnoreProperties("delegation")
	public List<User> getAllUsers()
	{
		return userControler.AllUser();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void registerUser(@RequestBody User user)
	{
		userControler.regUser(user);
	}
	
	@RequestMapping("/usersByRole")
	List<User> getAllUsersByRoleName(String roleName)
	{
		return userControler.getByRole(roleName);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{userId}")
	void changePassword(long userId, String newPassword)
	{
		userControler.UpdatePassword(userId, newPassword);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{userId}")
	boolean deleteUserById(long userId)
	{
		return userControler.DeleteUser(userId);
	}
}
