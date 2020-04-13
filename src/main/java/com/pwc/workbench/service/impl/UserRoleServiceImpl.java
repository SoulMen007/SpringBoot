package com.pwc.workbench.service.impl;

import com.pwc.workbench.dao.UserRoleMapper;
import com.pwc.workbench.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean isAdminUser(Long userId) {
        return userRoleMapper.selectIfIsAdmin(userId);
    }
}
