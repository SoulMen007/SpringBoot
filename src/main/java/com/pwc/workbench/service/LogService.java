package com.pwc.workbench.service;

import java.util.List;

import com.pwc.workbench.domain.Log;
import com.pwc.workbench.model.LogModel;

/**
 * 
 * @author jchen533
 *
 */
public interface LogService {
	
	public void insertLog(Log log);
	
	public List<LogModel> getLogByAction(String action,String actualDate);

}
