package com.spring.project.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by HauKute on 4/23/2019.
 */
@Entity
@Table(name = "Role")
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(name = "roleName")
    private String role;

	public long getRoleId() {

		return roleId;
	}

	public void setRoleId(long roleId) {

		this.roleId = roleId;
	}

	public String getRole() {

		return role;
	}

	public void setRole(String role) {

		this.role = role;
	}

    @Override
    public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RoleEntity that = (RoleEntity) o;

		if (roleId != that.roleId)
			return false;
		return role.equals(that.role);
    }

    @Override
    public int hashCode() {

		int result = (int) (roleId ^ (roleId >>> 32));
		result = 31 * result + role.hashCode();
		return result;
	}
}
