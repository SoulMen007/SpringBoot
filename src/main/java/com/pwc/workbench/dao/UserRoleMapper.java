package com.pwc.workbench.dao;

import org.apache.ibatis.annotations.Param;

import com.pwc.workbench.domain.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    UserRole getUploadPermissionUserById(Long userId);

    boolean selectIfIsAdmin(@Param("userId") Long userId);
}