package com.nga.springsecurityDemo.dao;

import com.nga.springsecurityDemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);

}
