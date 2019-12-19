package com.spring.project.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by HauKute on 4/1/2019.
 */
public class UserDTO implements Serializable {

	private Long userId;
	private String userName;
	private String password;
	private Timestamp createdDate;
	private int status;
	private List<RoleDTO> roles;

	public UserDTO() {

	}

	public UserDTO(
					long userId, String userName, String password, int status,
					Timestamp createdDate, List<RoleDTO> roles) {

		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.createdDate = createdDate;
		this.roles = roles;
	}

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public Timestamp getCreatedDate() {

		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {

		this.createdDate = createdDate;
	}

	public int getStatus() {

		return status;
	}

	public void setStatus(int status) {

		this.status = status;
	}

	public List<RoleDTO> getRoles() {

		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {

		this.roles = roles;
	}
}
