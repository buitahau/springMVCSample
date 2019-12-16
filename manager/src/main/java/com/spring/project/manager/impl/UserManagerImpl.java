package com.spring.project.manager.impl;

import com.spring.project.manager.UserManager;
import com.spring.project.common.RoleDTO;
import com.spring.project.common.UserDTO;
import com.spring.project.dao.UserDao;
import com.spring.project.dao.entity.RoleEntity;
import com.spring.project.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HauKute on 3/28/2019.
 */
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    UserDao userDao;

    public UserDTO loadUserByUsername(String userName) {

        UserDTO userDTO = null;
        UserEntity userEntity = this.userDao.loadUserByUsername(userName);
        if (userEntity != null) {
            List<RoleDTO> roles = new ArrayList<RoleDTO>();
            if (userEntity.getRoles().size() > 0) {
                for (RoleEntity roleEntity : userEntity.getRoles()) {
                    roles.add(new RoleDTO(
                                    roleEntity.getRoleId(),
                                    roleEntity.getRole()));
                }
            }
            userDTO = new UserDTO(userEntity.getUserId(),
                            userEntity.getUserName(), userEntity.getPassword(),
                            userEntity.getStatus(), userEntity.getCreatedDate(),
                            roles);
        }
        return userDTO;
    }
}
