package com.spring.project.dao;

import com.spring.project.dao.entity.UserEntity;

/**
 * Created by HauKute on 3/28/2019.
 */
public interface UserDao extends IGenericDao<UserEntity> {

	UserEntity loadUserByUsername(String userName);
}
