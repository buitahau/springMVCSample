package com.spring.project.manager;

import com.spring.project.common.UserDTO;

/**
 * Created by HauKute on 3/28/2019.
 */
public interface UserManager {

	UserDTO addUser(UserDTO userDTO);

	int countAll();

	UserDTO loadUserByUsername(String userName);
}
