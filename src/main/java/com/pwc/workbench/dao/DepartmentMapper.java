package com.pwc.workbench.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.pwc.workbench.domain.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> listAll();

    List<Department> listByUserId(Long userId);

    @MapKey("name")
    Map<String, Map<String, Object>> getNameToIdMap();
    
    //判断用户是否有Department下所有group的上传权限
    boolean selectUserHasAllGroupsUploadPermission(@Param("departmentId")Long departmentId, @Param("userId")Long userId);
}