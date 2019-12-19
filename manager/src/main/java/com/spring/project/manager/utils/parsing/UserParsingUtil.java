package com.spring.project.manager.utils.parsing;

import com.spring.project.common.dto.RoleDTO;
import com.spring.project.common.dto.UserDTO;
import com.spring.project.dao.entity.RoleEntity;
import com.spring.project.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HauKute on 12/18/2019.
 */
public class UserParsingUtil {

	public static UserEntity parseFromDtoToEntity(UserDTO dto) {

		if (null == dto) {
			return null;
		}

		Set<RoleEntity> roles = new HashSet<RoleEntity>();
		if (dto.getRoles() != null && dto.getRoles().size() > 0) {
			for (RoleDTO roleDTO : dto.getRoles()) {
				roles.add(RoleParsingUtil.parseFromDtoToEntity(roleDTO));
			}
		}

		UserEntity entity = new UserEntity();
		entity.setUserId(dto.getUserId());
		entity.setPassword(dto.getPassword());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setStatus(dto.getStatus());
		entity.setRoles(roles);
		entity.setUserName(dto.getUserName());
		return entity;
	}

	public static UserDTO parseFromEntityToDto(UserEntity entity) {

		if (null == entity) {
			return null;
		}

		List<RoleDTO> roles = new ArrayList<RoleDTO>();
		if (entity.getRoles() != null && entity.getRoles().size() > 0) {
			for (RoleEntity roleEntity : entity.getRoles()) {
				roles.add(RoleParsingUtil.parseFromEntityToDto(roleEntity));
			}
		}

		return new UserDTO(entity.getUserId(), entity.getUserName(),
						entity.getPassword(), entity.getStatus(),
						entity.getCreatedDate(), roles);
	}
}
