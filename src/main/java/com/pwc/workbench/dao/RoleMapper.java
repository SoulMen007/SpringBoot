package com.pwc.workbench.dao;

import com.pwc.workbench.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	Role getMenuByRole(String name);

	void updateMenuRole(String name, String firstMenu, String secondMenu, String accessType);

}