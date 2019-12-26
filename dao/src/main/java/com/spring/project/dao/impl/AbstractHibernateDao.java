package com.spring.project.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by HauKute on 4/21/2019.
 */
@Transactional
public abstract class AbstractHibernateDao<T extends Serializable> {

	private final Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	protected AbstractHibernateDao(Class<T> clazz) {

		this.clazz = clazz;
	}

	protected final Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	protected Class<? extends T> getEntityClass() {

		return this.clazz;
	}

	protected String getEntityName() {

		return this.getEntityClass().getName();
	}

	public void clear() {

		getCurrentSession().clear();
	}

	public void create(T entity) {

		getCurrentSession().persist(entity);
	}

	public void delete(T entity) {

		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {

		T entity = findOne(entityId);
		delete(entity);
	}

	public List<T> findAll() {

		return getCurrentSession().createQuery(
						"from " + this.getEntityName()).list();
	}

	public T findOne(long id) {

		return (T) getCurrentSession().get(clazz, id);
	}

	public void flush() {

		getCurrentSession().flush();
	}

	public void update(T entity) {

		getCurrentSession().merge(entity);
	}

	public void saveOrUpdate(T instanceOrEntity) {

		getCurrentSession().saveOrUpdate(
						this.getEntityName(), instanceOrEntity);
	}
}
