package com.pss_lab.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss_lab.model.Delegation;
import com.pss_lab.model.Role;
import com.pss_lab.model.User;
import com.pss_lab.repository.DelegationRepository;
import com.pss_lab.repository.RoleRepository;
import com.pss_lab.repository.UserRepository;

@Service
public class InitService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DelegationRepository delegationRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostConstruct
	public void Init()
	{		
		User user = new User();
		user.setUserId(new Long(0));
		user.setName("Jan");
		user.setLastName("Kowalski");
		user.setPassword("1234");
		user.setEmail("jankow@wp.pl");
		user.setCompanyNip("1234");
		user.setCompanyName("PyszneBułeczki");
		user.setCompanyAddress("Warszawa");
		
		Set<Role> roles = new HashSet<>();
		
		
		Role role = new Role();
		role.setRoleId(new Long(0));
		role.setRoleName("Test");
		roleRepository.save(role);
		
		roles.add(role);
		
		role = new Role();
		role.setRoleId(new Long(1));
		role.setRoleName("Rola testowa");
		roleRepository.save(role);
		
		roles.add(role);
		user.setRoles(roles);
		
		Delegation delegation = new Delegation();
		delegation.setDelegationId(new Long(0));
		delegation.setDescription("Podróż do Krakowa");
		
		GregorianCalendar calendar = new GregorianCalendar(2020, 3, 20);
		delegation.setDateTimeStart(new Timestamp(calendar.getTimeInMillis()));
		calendar = new GregorianCalendar(2020, 3, 22);
		delegation.setDateTimeStop(new Timestamp(calendar.getTimeInMillis()));
		delegation.setTransportType(Delegation.Transport.Pociąg);
		delegation.setKm((float) 253.0);
		
		Set<Delegation> delegations = new HashSet<>();
		
		delegations.add(delegation);
		
		user.setDelegations(delegations);
		
		delegation.setUser(user);
		
		userRepository.save(user);
		
		delegationRepository.save(delegation);
	}
}
