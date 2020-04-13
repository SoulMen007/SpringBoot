package com.pwc.workbench.task;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


/**
 * @author ssun206
 *
 */
@Configuration
@Component
@EnableScheduling // 该注解必须要加
public class ScheduleTask { 
	/*@Resource
	private SalesDetailDataManagementService  salesDetailDataManagementService;
	
	
     public void scheduleTest() {
         System.out.println("scheduleTest开始定时执行: "+ new Date());
         salesDetailDataManagementService.syncBITables("") ;
    }*/
     
     
}
