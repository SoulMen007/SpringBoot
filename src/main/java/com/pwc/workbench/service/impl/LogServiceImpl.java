package com.pwc.workbench.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.workbench.dao.LogMapper;
import com.pwc.workbench.domain.Log;
import com.pwc.workbench.model.LogModel;
import com.pwc.workbench.service.LogService;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogMapper logMapper;

	@Override
	//@Transactional(rollbackFor = Exception.class)
	public void insertLog(Log record) {
		logMapper.insert(record);
		
	}

	@Override
	public List<LogModel> getLogByAction(String action,String actualDate) {
		return logMapper.getLogByAction(action,actualDate);
	}

}
