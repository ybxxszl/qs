package com.wjy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class JobUtil implements Job {

	public static void main(String[] args) throws Exception {

		// 调度器
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();

		// 创建任务
		JobDetail jobDetail = JobBuilder.newJob(JobUtil.class).withIdentity("name", "group").build();

		// 创建触发器，每5秒执行一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("name", "group")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

		// 将任务和触发器放入调度器
		scheduler.scheduleJob(jobDetail, trigger);

		// 调度器开始执行任务
		scheduler.start();

	}

	public void execute(JobExecutionContext context) {
		System.out.println("定时任务 - " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}

}
