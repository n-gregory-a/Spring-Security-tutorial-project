package com.nga.springsecurityDemo.dao;

import com.nga.springsecurityDemo.entity.Role;

public interface RoleDao {

    Role findRoleByName(String roleName);

}
