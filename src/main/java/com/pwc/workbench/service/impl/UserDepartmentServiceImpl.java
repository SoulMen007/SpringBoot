package com.pwc.workbench.service.impl;

import com.pwc.workbench.dao.UserDepartmentMapper;
import com.pwc.workbench.service.UserDepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDepartmentServiceImpl implements UserDepartmentService {

    @Autowired
    private UserDepartmentMapper userDepartmentMapper;

    @Override
    public boolean selectIfExistUserId(Long userId) {
        return userDepartmentMapper.selectIfExistUserId(userId);
    }
}
