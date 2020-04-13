package com.pwc.workbench.util;

public class SearchDateUtil {
	
	public static String getSearchDate(Integer year,Integer month) {
		String searchDate = "";
		if(null!=year && null!=month) {			
			searchDate = year.toString() + "-" + month.toString() + "-"+ "01";			
		}else if(null!=year && null == month) {
			searchDate = year.toString() + "-" + "01" + "-"+"01";
		}
		return searchDate;
	}	

}
