package com.nga.springsecurityDemo.dao;

import com.nga.springsecurityDemo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    // session factory injection
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User findByUserName(String userName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using username
        Query<User> query = currentSession.createQuery("from User where userName=:userName", User.class);
        query.setParameter("userName",userName);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }

    @Override
    public void save(User user) {

    }
}
