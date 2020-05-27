package com.project.Laboratorium1;
/*
import org.apache.coyote.http11.Http11AprProtocol;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.project.Laboratorium1.controller.JDBCController;
import com.project.Laboratorium1.model.Delegation;
import com.project.Laboratorium1.model.Role;
import com.project.Laboratorium1.model.TransportType;
import com.project.Laboratorium1.model.User;
import com.project.Laboratorium1.services.DelegationService;
import com.project.Laboratorium1.services.UserService;*/

//@RunWith(value = SpringJUnit4ClassRunner.class)
/*@RunWith(SpringRunner.class)
@WebMvcTest(JDBCController.class)*/
public class JDBCControllerTests {
/*
	@Autowired
	private MockMvc mvc;

	@MockBean
	private DelegationService delegationService;

	@MockBean
	private UserService userService;

	@Test
	public void registerUserTest() throws Exception {
		User user;

		user = new User();
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);

		mvc.perform(MockMvcRequestBuilders.post("/registerUser").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("conpanyAddress", user.getCompanyAddress()).param("companyName", user.getCompanyName())
				.param("companyNip", user.getCompanyNip()).param("email", user.getEmail())
				.param("lastName", user.getLastName()).param("name", user.getName())
				.param("password", user.getPassword()).param("status", user.getStatus().toString()))
				.andExpect(status().isOk());

	}

	@Test
	public void getAllUsersTest() throws Exception {
		User user;

		user = new User();
		user.setUserId(1L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);

		List<User> users = Arrays.asList(user);

		given(userService.findAll()).willReturn(users);

		mvc.perform(get("/getAllUsers").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is(user.getName())));
	}

	@Test
	public void changePasswordTest() throws Exception {
		User user;

		user = new User();
		user.setUserId(3L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);

		mvc.perform(MockMvcRequestBuilders.put("/changePassword").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("userId", "3")

				.param("newPassword", "22222")).andExpect(status().isOk());

	}

	@Test
	public void deleteUserByIdTest() throws Exception {
		User user;

		user = new User();
		user.setUserId(1L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);

		mvc.perform(MockMvcRequestBuilders.delete("/deleteUserById").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("userId", "3")).andExpect(status().isOk());

	}

	@Test
	public void getAllUsersByRoleNameTest() throws Exception {
		User user;

		user = new User();
		user.setUserId(1L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);

		List<User> users = Arrays.asList(user);

		given(userService.getAllUsersByRoleName("Test")).willReturn(users);

		mvc.perform(get("/getAllUsersByRoleName").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("roleName",
				"Test")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is(user.getName())));
	}

	@Test
	public void addDelegation() throws Exception{
		User user;

		user = new User();
		user.setUserId(1L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		
		Delegation delegation;
		delegation = new Delegation();
		delegation.setDelegationId(1L);
		delegation.setAccomodationPrice(0.0);
		delegation.setAutoCapacity(true);
		delegation.setBreakfastNumber(0);
		delegation.setDescription("TEST");
		delegation.setDinnerNumber(0);
		delegation.setKm(0L);
		delegation.setOtherOutlayDesc(0.0);
		delegation.setOtherOutlayPrice(0.0);
		delegation.setOtherTicketsPrice(0.0);
		delegation.setSupperNumber(0);
		delegation.setTicketPrice(0.0);
		delegation.setTransportType(TransportType.TRAIN);
		delegation.setTravelDietAmount(0.0);
		delegation.setUser(user);
		
		List<User> users = Arrays.asList(user);
		
		mvc.perform(MockMvcRequestBuilders.post("/registerUser").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("description", delegation.getDescription())
				.param("travelDietAmount", delegation.getTravelDietAmount().toString())
				.param("breakfastNumber", delegation.getBreakfastNumber().toString())
				.param("dinnerNumber", delegation.getDinnerNumber().toString())
				.param("transportType", delegation.getTransportType().getName())
				.param("ticketPrice", delegation.getTicketPrice().toString())
				.param("autoCapacity", delegation.getAutoCapacity().toString())
				.param("km", delegation.getKm().toString())
				.param("accomodationPrice", delegation.getAccomodationPrice().toString())
				.param("otherTicketsPrice", delegation.getOtherTicketsPrice().toString())
				.param("otherOutlayDesc", delegation.getOtherOutlayDesc().toString())
				.param("otherOutlayPrice", delegation.getOtherOutlayPrice().toString())
				.param("userId", delegation.getUser().getUserId().toString()))
		.andExpect(status().isOk());
	}
	
	@Test
	public void changeDelegation() throws Exception{
		User user;

		user = new User();
		user.setUserId(3L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		
		Delegation delegation;
		delegation = new Delegation();
		delegation.setDelegationId(1L);
		delegation.setAccomodationPrice(0.0);
		delegation.setAutoCapacity(true);
		delegation.setBreakfastNumber(0);
		delegation.setDescription("TEST");
		delegation.setDinnerNumber(0);
		delegation.setKm(0L);
		delegation.setOtherOutlayDesc(0.0);
		delegation.setOtherOutlayPrice(0.0);
		delegation.setOtherTicketsPrice(0.0);
		delegation.setSupperNumber(0);
		delegation.setTicketPrice(0.0);
		delegation.setTransportType(TransportType.TRAIN);
		delegation.setTravelDietAmount(0.0);
		delegation.setUser(user);
		
		Delegation delegation2;
		delegation2 = new Delegation();
		delegation2.setDelegationId(3L);
		delegation2.setAccomodationPrice(0.0);
		delegation2.setAutoCapacity(true);
		delegation2.setBreakfastNumber(0);
		delegation2.setDescription("TEST");
		delegation2.setDinnerNumber(0);
		delegation2.setKm(0L);
		delegation2.setOtherOutlayDesc(0.0);
		delegation2.setOtherOutlayPrice(0.0);
		delegation2.setOtherTicketsPrice(0.0);
		delegation2.setSupperNumber(0);
		delegation2.setTicketPrice(0.0);
		delegation2.setTransportType(TransportType.TRAIN);
		delegation2.setTravelDietAmount(0.0);
		delegation2.setUser(user);
		
		List<User> users = Arrays.asList(user);
		
		mvc.perform(MockMvcRequestBuilders.put("/changeDelegation").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("delegationId", delegation2.getDelegationId().toString())
				.param("description", delegation2.getDescription())
				.param("travelDietAmount", delegation2.getTravelDietAmount().toString())
				.param("breakfastNumber", delegation2.getBreakfastNumber().toString())
				.param("dinnerNumber", delegation2.getDinnerNumber().toString())
				.param("transportType", delegation2.getTransportType().toString())
				.param("ticketPrice", delegation2.getTicketPrice().toString())
				.param("autoCapacity", delegation2.getAutoCapacity().toString())
				.param("km", delegation2.getKm().toString())
				.param("accomodationPrice", delegation2.getAccomodationPrice().toString())
				.param("otherTicketsPrice", delegation2.getOtherTicketsPrice().toString())
				.param("otherOutlayDesc", delegation2.getOtherOutlayDesc().toString())
				.param("otherOutlayPrice", delegation2.getOtherOutlayPrice().toString())
				.param("userId", delegation2.getUser().getUserId().toString()))
		.andExpect(status().isOk());
	}
	
	@Test
	public void getAllDelegationsTest() throws Exception{
		User user;

		user = new User();
		user.setUserId(3L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		
		Delegation delegation;
		delegation = new Delegation();
		delegation.setDelegationId(1L);
		delegation.setAccomodationPrice(0.0);
		delegation.setAutoCapacity(true);
		delegation.setBreakfastNumber(0);
		delegation.setDescription("TEST");
		delegation.setDinnerNumber(0);
		delegation.setKm(0L);
		delegation.setOtherOutlayDesc(0.0);
		delegation.setOtherOutlayPrice(0.0);
		delegation.setOtherTicketsPrice(0.0);
		delegation.setSupperNumber(0);
		delegation.setTicketPrice(0.0);
		delegation.setTransportType(TransportType.TRAIN);
		delegation.setTravelDietAmount(0.0);
		delegation.setUser(user);
		
		Delegation delegation2;
		delegation2 = new Delegation();
		delegation2.setDelegationId(3L);
		delegation2.setAccomodationPrice(0.0);
		delegation2.setAutoCapacity(true);
		delegation2.setBreakfastNumber(0);
		delegation2.setDescription("Wafel");
		delegation2.setDinnerNumber(0);
		delegation2.setKm(0L);
		delegation2.setOtherOutlayDesc(0.0);
		delegation2.setOtherOutlayPrice(0.0);
		delegation2.setOtherTicketsPrice(0.0);
		delegation2.setSupperNumber(0);
		delegation2.setTicketPrice(0.0);
		delegation2.setTransportType(TransportType.TRAIN);
		delegation2.setTravelDietAmount(0.0);
		delegation2.setUser(user);
		
		List<Delegation> delegations = Arrays.asList(delegation,delegation2);
		
		

		given(delegationService.findAll()).willReturn(delegations);

		mvc.perform(get("/getAllDelegations").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].description", is(delegation.getDescription())));
		
		
	}
	
	@Test
	public void getAllDelegationsOrderByDateStartDesc() throws Exception{
		User user;

		user = new User();
		user.setUserId(3L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		
		Delegation delegation;
		delegation = new Delegation();
		delegation.setDelegationId(1L);
		delegation.setAccomodationPrice(0.0);
		delegation.setAutoCapacity(true);
		delegation.setBreakfastNumber(0);
		delegation.setDescription("TEST");
		delegation.setDinnerNumber(0);
		delegation.setKm(0L);
		delegation.setOtherOutlayDesc(0.0);
		delegation.setOtherOutlayPrice(0.0);
		delegation.setOtherTicketsPrice(0.0);
		delegation.setSupperNumber(0);
		delegation.setTicketPrice(0.0);
		delegation.setTransportType(TransportType.TRAIN);
		delegation.setTravelDietAmount(0.0);
		delegation.setUser(user);
		
		Delegation delegation2;
		delegation2 = new Delegation();
		delegation2.setDelegationId(3L);
		delegation2.setAccomodationPrice(0.0);
		delegation2.setAutoCapacity(true);
		delegation2.setBreakfastNumber(0);
		delegation2.setDescription("Wafel");
		delegation2.setDinnerNumber(0);
		delegation2.setKm(0L);
		delegation2.setOtherOutlayDesc(0.0);
		delegation2.setOtherOutlayPrice(0.0);
		delegation2.setOtherTicketsPrice(0.0);
		delegation2.setSupperNumber(0);
		delegation2.setTicketPrice(0.0);
		delegation2.setTransportType(TransportType.TRAIN);
		delegation2.setTravelDietAmount(0.0);
		delegation2.setUser(user);
		
		List<Delegation> delegations = Arrays.asList(delegation,delegation2);
		
		

		given(delegationService.findAllOrderByDateStartDesc()).willReturn(delegations);

		mvc.perform(get("/getAllDelegationsOrderByDateStartDesc").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].description", is(delegation.getDescription())));
		
		
	}
	
	@Test
	public void getAllDelByUserOrderByDateStartDescTest() throws Exception{
		User user;

		user = new User();
		user.setUserId(1L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		User user2;

		user2 = new User();
		user2.setUserId(3L);
		user2.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user2.setCompanyName("PeterCorp");
		user2.setCompanyNip("11111111111");
		user2.setEmail("TEST@gmail.com");
		user2.setLastName("Kowalski");
		user2.setName("Jan");
		user2.setPassword("1234");
		user2.setStatus(true);
		roles.add(role);
		user2.setRole(roles);
		
		Delegation delegation;
		delegation = new Delegation();
		delegation.setDelegationId(1L);
		delegation.setAccomodationPrice(0.0);
		delegation.setAutoCapacity(true);
		delegation.setBreakfastNumber(0);
		delegation.setDescription("TEST");
		delegation.setDinnerNumber(0);
		delegation.setKm(0L);
		delegation.setOtherOutlayDesc(0.0);
		delegation.setOtherOutlayPrice(0.0);
		delegation.setOtherTicketsPrice(0.0);
		delegation.setSupperNumber(0);
		delegation.setTicketPrice(0.0);
		delegation.setTransportType(TransportType.TRAIN);
		delegation.setTravelDietAmount(0.0);
		delegation.setUser(user);
		
		Delegation delegation2;
		delegation2 = new Delegation();
		delegation2.setDelegationId(3L);
		delegation2.setAccomodationPrice(0.0);
		delegation2.setAutoCapacity(true);
		delegation2.setBreakfastNumber(0);
		delegation2.setDescription("Wafel");
		delegation2.setDinnerNumber(0);
		delegation2.setKm(0L);
		delegation2.setOtherOutlayDesc(0.0);
		delegation2.setOtherOutlayPrice(0.0);
		delegation2.setOtherTicketsPrice(0.0);
		delegation2.setSupperNumber(0);
		delegation2.setTicketPrice(0.0);
		delegation2.setTransportType(TransportType.TRAIN);
		delegation2.setTravelDietAmount(0.0);
		delegation2.setUser(user2);
		
		List<Delegation> delegations = Arrays.asList(delegation,delegation2);
		
		

		given(delegationService.findByUserOrderByDateStartDesc(user.getUserId())).willReturn(delegations);

		mvc.perform(get("/getAllDelegationsByUserOrderByDateStartDesc").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("userId", user.getUserId().toString())).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].description", is(delegation.getDescription())));
		
		
	}
	
	@Test
	public void removeDelegation() throws Exception {
		User user;

		user = new User();
		user.setUserId(1L);
		user.setCompanyAddress("Wojtyły 12 88-T99 bydgoszcz");
		user.setCompanyName("PeterCorp");
		user.setCompanyNip("11111111111");
		user.setEmail("TEST@gmail.com");
		user.setLastName("Kowalski");
		user.setName("Jan");
		user.setPassword("1234");
		user.setStatus(true);
		Role role = new Role();
		role.setRoleName("Test");
		role.setRoleId(1L);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);

		mvc.perform(MockMvcRequestBuilders.delete("/removeDelegation").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("userId", "3")
				.param("delegationId", "3"))
		.andExpect(status().isOk());

	}*/
}
