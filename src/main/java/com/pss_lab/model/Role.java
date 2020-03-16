package com.pss_lab.model;

import java.io.Serializable;
import javax.persistence. *;

import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role {
	
	@Id
	private Long roleId;
	
	String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	} 

}
