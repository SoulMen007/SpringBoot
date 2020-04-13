package com.pwc.workbench.dao;

import com.pwc.workbench.domain.UserOrganization;
import com.pwc.workbench.model.UserOrganizationModel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOrganization record);

    int insertSelective(UserOrganization record);

    UserOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOrganization record);

    int updateByPrimaryKey(UserOrganization record);

    List<UserOrganizationModel> getUserOrganization(@Param("userId")Long userId,@Param("authorizationType")String authorizationType );

    boolean selectIfHasUploadPermission(@Param("userId") Long userId);

    boolean selectIfHasDownloadPermission(@Param("userId") Long userId);
}