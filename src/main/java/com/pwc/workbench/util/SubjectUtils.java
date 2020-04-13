package com.pwc.workbench.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public final class SubjectUtils {
private static final String USER_ID = "userId";
	
	public static String getUserName() {
		return (String) SecurityUtils.getSubject().getPrincipal();
	}
	
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
	
	public static Long getUserId(){
		return (Long) getSession().getAttribute(USER_ID);
	}
	
	public static void setUserId(String userId){
		getSession().setAttribute(USER_ID, userId);
	}
}
