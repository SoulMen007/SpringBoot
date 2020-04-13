/**
 * 
 */
package com.pwc.workbench.task;

import java.util.Date;

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
public class SecondTask {
	public void secondTask() {
        //System.out.println("scheduleTest开始定时执行(2): "+ new Date());
   }

}
