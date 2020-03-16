package com.pss_lab.model;

import java.io.Serializable;
import javax.persistence. *;

import lombok.Data;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name ="user")
public class User {
	
	@Id
	private Long userId;
	
	@GeneratedValue
	@ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private Set<Delegation> delegations = new HashSet<>();
    
    @Column(nullable = false)
	private String companyName; // - obowiązkowe
    
    @Column(nullable = false)
	private String companyAddress; // - obowiązkowe
    
    @Column(nullable = false)
	private String companyNip; // - obowiązkowe
    
    @Column(nullable = false)
	private String name; // - obowiązkowe
    
    @Column(nullable = false)
	private String lastName; // - obowiązkowe
    
    @Column(nullable = false)
	private String email; // - obowiązkowe
    
    @Column(nullable = false)
	private String password; // - obowiązkowe
    
	@GeneratedValue
	private Boolean status = true; // - generowane automatycznie true
	
	@GeneratedValue
	private LocalDateTime registrationDate = LocalDateTime.now(); // - generowane automatycznie now()
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyNip() {
		return companyNip;
	}
	public void setCompanyNip(String companyNip) {
		this.companyNip = companyNip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Delegation> getDelegations() {
		return delegations;
	}
	public void setDelegations(Set<Delegation> delegations) {
		this.delegations = delegations;
	}
	
}
