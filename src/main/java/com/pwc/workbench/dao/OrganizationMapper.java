package com.pwc.workbench.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pwc.workbench.domain.Organization;
import com.pwc.workbench.domain.OrganizationMode;
import com.pwc.workbench.domain.RoleMode;
import com.pwc.workbench.domain.UserMode;
import com.pwc.workbench.domain.UserOrganizationRoleMode;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    Organization getByName(String name);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

	List<UserOrganizationRoleMode> getOrganizationsByUserId(Long userId);


    List<UserMode> getUserModes(@Param("userId") Long userId);

    List<OrganizationMode> getOrganizationModes(@Param("userId") Long userId);

    List<OrganizationMode> getUserOrganizationModes(@Param("userId") Long userId);

    List<RoleMode> getRoleModes(@Param("userId") Long userId);

    List<Organization> listByDepartmentId(@Param("departmentId") Long departmentId);

    Set<Long> listIdByDepartmentPermission(@Param("userId") Long userId);

    @MapKey("code")
    Map<String, Map<String, Object>> getCodeToIdMap();

}