package com.project.Laboratorium1.model;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@ManyToMany
	private Set<Role> role;

	@Column( nullable = false)
	@NotNull
	private String companyName;

	@Column( nullable = false)
	@NotNull
	private String companyAddress;

	@Column( nullable = false)
	@NotNull
	private String companyNip;

	@Column( nullable = false)
	@NotNull
	private String name;

	@Column( nullable = false)
	@NotNull
	private String lastName;

	@Column( nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotNull
	private String email;

	@Column( nullable = false)
	@NotNull
	private String password;

	@Column( nullable = false)
	@NotNull
	private Boolean status = true;

	@Column( nullable = false)
	//@NotNull
	private Timestamp registrationDate;

	@OneToMany
    private Set<Delegation> delegations;
	
}
