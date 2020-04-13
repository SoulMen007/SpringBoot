package com.pwc.workbench.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pwc.workbench.domain.UsersOrganization;
import com.pwc.workbench.model.UsersOrganizationModel;

public interface UsersOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersOrganization record);

    int insertSelective(UsersOrganization record);

    UsersOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersOrganization record);

    int updateByPrimaryKey(UsersOrganization record);

	List<UsersOrganizationModel> getUserOrg(Long usersId);

	List<UsersOrganizationModel> getDomainsByUserOrg(@Param("usersId")Long usersId, @Param("parentId")Long parentId);
}