package com.pwc.workbench.dao;

import org.apache.ibatis.annotations.Param;

import com.pwc.workbench.domain.UserDepartment;

public interface UserDepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDepartment record);

    int insertSelective(UserDepartment record);

    UserDepartment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDepartment record);

    int updateByPrimaryKey(UserDepartment record);

    boolean selectIfExistUserId(@Param("userId") Long userId);
}