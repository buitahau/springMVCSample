package com.spring.project.manager.impl;

import com.spring.project.manager.UserManager;
import com.spring.project.common.dto.RoleDTO;
import com.spring.project.common.dto.UserDTO;
import com.spring.project.dao.UserDao;
import com.spring.project.dao.entity.RoleEntity;
import com.spring.project.dao.entity.UserEntity;
import com.spring.project.manager.utils.parsing.UserParsingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HauKute on 3/28/2019.
 */
@Transactional
@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDao userDao;

	public UserDTO addUser(UserDTO userDTO) {

		//TODO: need validate in here before persist

		UserEntity userEntity = UserParsingUtil.parseFromDtoToEntity(userDTO);
		userEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
		userEntity.setPassword(hashedPassword);

		userDao.create(userEntity);
		return UserParsingUtil.parseFromEntityToDto(userEntity);
	}

	public int countAll() {

		return userDao.countAll();
	}

	public UserDTO findById(long userId) {

		UserEntity u = userDao.findOneBySerializeId(userId);
		return UserParsingUtil.parseFromEntityToDto(u);
	}

	public UserDTO loadUserByUsername(String userName) {

		UserDTO userDTO = null;
		UserEntity userEntity = userDao.loadUserByUsername(userName);
		if (userEntity != null) {
			List<RoleDTO> roles = new ArrayList<RoleDTO>();
			if (userEntity.getRoles().size() > 0) {
				for (RoleEntity roleEntity : userEntity.getRoles()) {
					roles.add(new RoleDTO(roleEntity.getRoleId(),
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
