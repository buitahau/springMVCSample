package com.spring.project.manager;

import com.spring.project.common.dto.UserDTO;

/**
 * Created by HauKute on 3/28/2019.
 */
public interface UserManager {

	UserDTO addUser(UserDTO userDTO);

	int countAll();

	UserDTO findById(long userId);

	UserDTO loadUserByUsername(String userName);
}
