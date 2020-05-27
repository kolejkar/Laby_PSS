package com.project.Laboratorium1.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.Laboratorium1.model.Delegation;
import com.project.Laboratorium1.model.User;
import com.project.Laboratorium1.services.IDelegationService;
import com.project.Laboratorium1.services.IUserService;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class JDBCController {
	@Autowired
	private IDelegationService delegationService;
	@Autowired
	private IUserService userService;



	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public void registerUser(@Valid @ModelAttribute User user) {
		
		user.setRegistrationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
		user.setStatus(true);
		userService.save(user);

	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(@RequestParam("userId") long userId) {
		return userService.findById(userId);
	}

	@RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUserByEmail(@RequestParam("email") String email) {
		return userService.findByEmail(email);
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
	@ResponseBody
	public void changePassword(@RequestParam("userId") long userId, @RequestParam("newPassword") String newPassword) {
		userService.updatePassword(userId, newPassword);
	}

	@RequestMapping(value = "/deleteUserById", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteUserById(@RequestParam("userId") Integer userId) {
		
		
		
		return userService.deleteById(userId.longValue());

	}

	@RequestMapping(value = "/getAllUsersByRoleName", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsersByRoleName(@RequestParam("roleName") String roleName) {
		return userService.getAllUsersByRoleName(roleName);
	}

	@RequestMapping(value = "/addDelegation", method = RequestMethod.POST)
	@ResponseBody
	public void addDelegation(@RequestParam("userId") long userId, @Valid @ModelAttribute Delegation delegation) {

		
		delegationService.save(userId, delegation);

	}

	@RequestMapping(value = "/removeDelegation", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean removeDelegation(@RequestParam("userId") long userId,
			@RequestParam("delegationId") long delegationId) {
		if (delegationId != 0L) {
			return delegationService.deleteById(delegationId);
		} else if (userId != 0L) {
			return delegationService.deleteByUser(userId);
		}
		return false;

	}

	@RequestMapping(value = "/changeDelegation", method = RequestMethod.PUT)
	@ResponseBody
	public void changeDelegation(@RequestParam("delegationId") long delegationId,
								 @Valid @ModelAttribute Delegation delegation) {
		
		
		
		delegationService.updateDelegation(delegationId, delegation);
	}
	
	@RequestMapping(value = "/getAllDelegations", method = RequestMethod.GET)
	@ResponseBody
	public List<Delegation> getAllDelegations(){
		return delegationService.findAll();
		
	}
	
	@RequestMapping(value = "/getAllDelegationsOrderByDateStartDesc", method = RequestMethod.GET)
	@ResponseBody
	public List<Delegation> getAllDelegationsOrderByDateStartDesc(){
		return delegationService.findAllOrderByDateStartDesc();
		
	}
	
	@RequestMapping(value = "/getAllDelegationsByUserOrderByDateStartDesc", method = RequestMethod.GET)
	@ResponseBody
	public List<Delegation> getAllDelegationsByUserOrderByDateStartDesc(@RequestParam("userId") Long userId){
		return delegationService.findByUserOrderByDateStartDesc(userId);
		
	}

}
