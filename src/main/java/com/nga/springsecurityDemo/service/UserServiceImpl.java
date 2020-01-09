package com.nga.springsecurityDemo.service;

import com.nga.springsecurityDemo.user.CrmUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {
    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public void save(CrmUser crmUser) {

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
