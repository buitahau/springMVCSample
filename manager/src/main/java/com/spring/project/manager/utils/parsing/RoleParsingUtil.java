package com.spring.project.manager.utils.parsing;

import com.spring.project.common.RoleDTO;
import com.spring.project.dao.entity.RoleEntity;

/**
 * Created by HauKute on 12/18/2019.
 */
public class RoleParsingUtil {

	public static RoleEntity parseFromDtoToEntity(RoleDTO dto) {

		if (null == dto) {

			return null;
		}
		RoleEntity entity = new RoleEntity();
		entity.setRole(dto.getRole());
		entity.setRoleId(dto.getRoleId());
		return entity;
	}

	public static RoleDTO parseFromEntityToDto(RoleEntity entity) {

		if (null == entity) {

			return null;
		}
		return new RoleDTO(entity.getRoleId(), entity.getRole());
	}
}
