package com.nga.springsecurityDemo.service;

import com.nga.springsecurityDemo.entity.User;
import com.nga.springsecurityDemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
