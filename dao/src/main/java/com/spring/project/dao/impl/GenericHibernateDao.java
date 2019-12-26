package com.spring.project.dao.impl;

import com.spring.project.dao.IGenericDao;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by HauKute on 4/21/2019.
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<T extends Serializable>
				extends AbstractHibernateDao<T> implements IGenericDao<T> {

	public GenericHibernateDao(Class<T> clazz) {

		super(clazz);
	}
}
