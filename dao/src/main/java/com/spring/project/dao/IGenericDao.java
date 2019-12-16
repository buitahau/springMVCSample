package com.spring.project.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HauKute on 4/21/2019.
 */
public interface IGenericDao<T extends Serializable> {

	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
}
