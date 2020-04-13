package com.pwc.workbench.config;

import javax.annotation.Resource;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.pwc.workbench.task.ScheduleTask;
import com.pwc.workbench.task.SecondTask;

/**
 * @author ssun206
 *
 */

//@Configuration
public class QuartzConfigration {
	
	@Resource
	private EssSettings essSettings;

	/**
     *  配置任务
     * @param ScheduleTask为需要执行的任务
     * @return
     */
	@Bean(name = "firstJobDetail")  
    public MethodInvokingJobDetailFactoryBean firstJobDetail(ScheduleTask task) {
        // ScheduleTask为需要执行的任务  
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();  
        /* 
         *  是否并发执行 ,例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了， 
         *  如果此处为true，则下一个任务会bing执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行 
         */  
        jobDetail.setConcurrent(true);  

        jobDetail.setName("scheduler");// 设置任务的名字  
        jobDetail.setGroup("scheduler_group");// 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用  

        /* 
         * 这两行代码表示执行task对象中的scheduleTest方法。定时执行的逻辑都在scheduleTest。
         */  
        jobDetail.setTargetObject(task);  
        jobDetail.setTargetMethod("scheduleTest");  
        
        return jobDetail;  
    } 
	
	/**
     * 定时触发器
     * @param reptilianJob 任务
     * @return
     */
    @Bean(name = "firstTrigger")  
    public CronTriggerFactoryBean firstTrigger(JobDetail firstJobDetail) {  
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();  
        tigger.setJobDetail(firstJobDetail);  
        tigger.setCronExpression(essSettings.getCronExpression());// 表示每隔6秒钟执行一次
        //tigger.set
//        tigger.setName("myTigger");// trigger的name  
        return tigger;  
    }
    
    @Bean(name = "secondJobDetail")  
    public MethodInvokingJobDetailFactoryBean secondJobDetail(SecondTask secondTask) {
        // ScheduleTask为需要执行的任务  
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();  
        /* 
         *  是否并发执行 ,例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了， 
         *  如果此处为true，则下一个任务会bing执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行 
         */  
        jobDetail.setConcurrent(true);  
        jobDetail.setName("scheduler2");// 设置任务的名字  
        jobDetail.setGroup("scheduler_group");// 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用  
        /* 
         * 这两行代码表示执行task对象中的scheduleTest方法。定时执行的逻辑都在scheduleTest。
         */  
        jobDetail.setTargetObject(secondTask);  
        jobDetail.setTargetMethod("secondTask");  
        return jobDetail;  
    } 
	@Bean(name = "secondJobTrigger")  
    public CronTriggerFactoryBean secondJobTrigger(JobDetail secondJobDetail) {  
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();  
        tigger.setJobDetail(secondJobDetail);  
        tigger.setCronExpression(essSettings.getCronExpression());// 表示每隔6秒钟执行一次
        //tigger.set
//        tigger.setName("myTigger");// trigger的name  
        return tigger;  
    }

    /**
     * 调度工厂
     * @param jobTrigger 触发器
     * @return
     */
    @Bean(name = "scheduler")  
    public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger, Trigger secondJobTrigger) {  
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        //设置是否任意一个已定义的Job会覆盖现在的Job。默认为false，即已定义的Job不会覆盖现有的Job。
        bean.setOverwriteExistingJobs(false);  
        // 延时启动，应用启动5秒后  ，定时器才开始启动
        bean.setStartupDelay(5);  
        // 注册定时触发器  
        bean.setTriggers(firstTrigger, secondJobTrigger);  
        return bean;  
    }
    
    //多任务时的Scheduler，动态设置Trigger。一个SchedulerFactoryBean可能会有多个Trigger
    @Bean(name = "multitaskScheduler") 
    public SchedulerFactoryBean schedulerFactoryBean(){  
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();   
        return schedulerFactoryBean;   
    }
}
