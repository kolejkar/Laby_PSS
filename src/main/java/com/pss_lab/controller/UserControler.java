package com.pss_lab.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss_lab.model.Role;
import com.pss_lab.model.User;
import com.pss_lab.repository.UserRepository;

import ch.qos.logback.core.joran.action.Action;

@Service
public class UserControler {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private TicketRepository ticketRepository;
	
	public UserControler() {
		// TODO Auto-generated constructor stub
	}

	public List<User> AllUser()
	{
		List<User> users=new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void regUser(User user)
	{
		userRepository.save(user);
	}

	public void UpdatePassword(long id, String password) {
		userRepository.getOne(id).setPassword(password);
		userRepository.flush();
	}
	
	public boolean DeleteUser(long id)
	{
		if (userRepository.findById(id) !=null)
		{
				userRepository.deleteById(id);
				return true;
		}
		return false;
	}
	
	
	public List<User> getByRole(String role_name)
	{
		List <User> users = new ArrayList();
		for (User user : userRepository.findAll()) {
			
			Set<Role> roles = user.getRoles();
			for (Role role : roles) {
				if (role.getRoleName() == role_name)
				{
					users.add(user);
					break;
				}
			}
		}
		return users;
	}
	
}
