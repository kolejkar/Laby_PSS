package com.pss_lab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss_lab.model.Delegation;
import com.pss_lab.model.User;
import com.pss_lab.repository.DelegationRepository;
import com.pss_lab.repository.UserRepository;

@Service
public class DelegationControler {
	
	@Autowired
	private DelegationRepository delegationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public DelegationControler() {
		// TODO Auto-generated constructor stub
	}

	public List<Delegation> AllDelegation()
	{
		List<Delegation> delegations=new ArrayList<>();
		delegationRepository.findAll().forEach(delegations::add);
		return delegations;
	}
	
	public void regDelegation(long id, Delegation delegation)
	{
		delegation.setUser(userRepository.getOne(id));
		delegationRepository.save(delegation);
	}

	public void UpdateDelegation(long id, Delegation delegation) {
		//delegationRepository.;
	}
	
	public boolean DeleteDelegation(long UserId, long id)
	{
		Delegation delegation = delegationRepository.getOne(id);
		if (delegation !=null && delegation.getUser().getUserId() == UserId)
		{				
			delegationRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Delegation> GetAllDelegationsByUserOrderByDateStartDesc()
	{
		List<Delegation> delegations=new ArrayList<>();
		delegations = delegationRepository.findAll();
		for (Delegation delegation : delegations) {
			User user = delegation.getUser();
			user.getRegistrationDate();
		}
		return null;
	}
	
}
