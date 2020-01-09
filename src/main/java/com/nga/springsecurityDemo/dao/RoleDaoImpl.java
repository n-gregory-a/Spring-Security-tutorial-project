package com.nga.springsecurityDemo.dao;

import com.nga.springsecurityDemo.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{

    // session factory injection
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findRoleBuName(String roleName) {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve from database using name
        Query<Role> query = currentSession.createQuery("from Role where name=:roleName", Role.class);
        query.setParameter("roleName", roleName);

        Role role = null;

        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            role = null;
        }
        return role;
    }
}
