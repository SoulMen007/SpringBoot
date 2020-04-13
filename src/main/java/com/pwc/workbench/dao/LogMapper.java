package com.pwc.workbench.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pwc.workbench.domain.Log;
import com.pwc.workbench.model.LogModel;

public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

	List<LogModel> getLogByAction(@Param("action") String action,@Param("actualDate") String actualDate);
}