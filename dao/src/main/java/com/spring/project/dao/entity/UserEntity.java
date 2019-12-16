package com.spring.project.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HauKute on 4/1/2019.
 */
@Entity
@Table(name = "User")
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "createdDate")
    private Timestamp createdDate;

    @Column(name = "status")
    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "User_Role",
        joinColumns = {@JoinColumn(name = "userId")},
        inverseJoinColumns = {@JoinColumn(name = "roleId")})
    Set<RoleEntity> roles = new HashSet<RoleEntity>();

    public Set<RoleEntity> getRoles() {

        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {

        this.roles = roles;
    }

    public UserEntity() {

    }

    public UserEntity(
                    long userId, String userName, String password,
                    Integer status) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setCreatedDate(Timestamp createdDate) {

        this.createdDate = createdDate;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public Long getUserId() {

        return userId;
    }

    public String getPassword() {

        return password;
    }

    public Timestamp getCreatedDate() {

        return createdDate;
    }

    public Integer getStatus() {

        return status;
    }

    public String getUserName() {

        return userName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserEntity that = (UserEntity) o;

        if (!userId.equals(that.userId))
            return false;
        if (!userName.equals(that.userName))
            return false;
        if (!password.equals(that.password))
            return false;
        if (!createdDate.equals(that.createdDate))
            return false;
        return status.equals(that.status);
    }

    @Override
    public int hashCode() {

        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
