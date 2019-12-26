package com.spring.project.dao.impl;

import com.spring.project.dao.RoleDao;
import com.spring.project.dao.entity.RoleEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HauKute on 12/18/2019.
 */
@Repository
@Transactional
public class RoleDaoImpl extends GenericHibernateDao<RoleEntity>
				implements RoleDao {

	public RoleDaoImpl() {

		super(RoleEntity.class);
	}
}
