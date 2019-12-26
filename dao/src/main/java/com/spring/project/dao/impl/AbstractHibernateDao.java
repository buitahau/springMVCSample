package com.spring.project.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by HauKute on 4/21/2019.
 */
@Transactional
public abstract class AbstractHibernateDao<T extends Serializable> {

	private Class<T> clazz;

	private SessionFactory sessionFactory;

	protected AbstractHibernateDao(Class<T> clazz, SessionFactory sessionFactory) {

		this.clazz = clazz;
		this.sessionFactory = sessionFactory;
	}

	protected final Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public T findOne(long id) {

		return (T) getCurrentSession().get(clazz.getName(), id);
	}

	@SuppressWarnings("unchecked")
	public T findOneBySerializeId(long id){

		return getCurrentSession().get(clazz, id);
	}

	public List<T> findAll() {

		return getCurrentSession().createQuery(
						"from " + clazz.getName()).list();
	}

	public void create(T entity) {

		getCurrentSession().persist(entity);
	}

	public void update(T entity) {

		getCurrentSession().merge(entity);
	}

	public void delete(T entity) {

		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {

		T entity = findOne(entityId);
		delete(entity);
	}
}
