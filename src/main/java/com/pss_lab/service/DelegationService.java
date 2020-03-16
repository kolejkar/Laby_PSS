package com.pss_lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pss_lab.controller.DelegationControler;
import com.pss_lab.model.Delegation;

@RestController
public class DelegationService {
	
	@Autowired
	private DelegationControler delegationControler;
	
	public DelegationService() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/delegations")
	@JsonIgnoreProperties("users")
	public List<Delegation> getAllDelegation()
	{
		return delegationControler.AllDelegation();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/delegations")
	void addDelegation(long userId, Delegation delegation)
	{
		delegationControler.regDelegation(userId, delegation);
	}
	
	/*@RequestMapping("/delegations")
	List<Delegation> getAllDelegationsOrderByDateStartDesc()
	{
		//return delegationControler;
		return null;
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/delegations")
	List<Delegation> getAllDelegationsByUserOrderByDateStartDesc()
	{
		return null;
		
	}*/
	
	@RequestMapping(method=RequestMethod.PUT, value="/delegations/{DelegationId}")
	void changeDelegation(long DelegationId, Delegation delegation)
	{
		delegationControler.UpdateDelegation(DelegationId, delegation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delegations/{DelegationId}")
	boolean removeDelegation(long userId, long delegationId)
	{
		return delegationControler.DeleteDelegation(userId, delegationId);
	}

}
