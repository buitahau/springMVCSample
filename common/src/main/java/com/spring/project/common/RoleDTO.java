package com.spring.project.common;

import java.io.Serializable;

/**
 * Created by HauKute on 5/4/2019.
 */
public class RoleDTO implements Serializable {

	private long roleId;
	private String role;

	public RoleDTO() {

	}

	public RoleDTO(long roleId, String role) {

		this.roleId = roleId;
		this.role = role;
	}

	public String getRole() {

		return role;
	}

	public void setRole(String role) {

		this.role = role;
	}

	public long getRoleId() {

		return roleId;
	}

	public void setRoleId(long roleId) {

		this.roleId = roleId;
	}
}
