package com.pwc.workbench.dao;

import org.apache.ibatis.annotations.Param;

import com.pwc.workbench.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User getUserByLogin(@Param("email")String email, @Param("password")String password);

    User validateEmail(@Param("email")String email);

    List<User> getUsers(@Param("userName")String userName);
}