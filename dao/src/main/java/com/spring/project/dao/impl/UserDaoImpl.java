package com.spring.project.dao.impl;

import com.spring.project.dao.UserDao;
import com.spring.project.dao.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HauKute on 3/28/2019.
 */
@Repository
@Transactional
public class UserDaoImpl extends GenericHibernateDao<UserEntity>
                implements UserDao {

    public UserDaoImpl(
                    Class<UserEntity> clazz, SessionFactory sessionFactory) {

        super(clazz, sessionFactory);
    }

    public int countAll() {

        StringBuilder builder = new StringBuilder(
                        "Select count(*) from UserEntity");

        Query query = getCurrentSession().createQuery(builder.toString());

        return Integer.valueOf(query.uniqueResult().toString());
    }

    /**
     * Find user by userName
     * @param userName
     * @return
     */
    public UserEntity loadUserByUsername(String userName) {

        StringBuilder builder = new StringBuilder(
                        "from UserEntity where userName like :user");

        Query query = getCurrentSession().createQuery(
                        builder.toString()).setParameter("user", userName);

        return (UserEntity) query.uniqueResult();
    }
}
