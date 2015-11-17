package ch10.se05;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyQuartzServer {

	public static void startScheduler() throws SchedulerException {
		// 使用工厂创建调度器实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 以Job实现类创建JobDetail实例
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
				.withIdentity("fkJob").build();
		// 创建一个Trigger对象，该对象代表一个简单的任务执行方式，任务的触发器
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("fkTrigger", "fkTriggerGroup")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(60)
						.repeatForever())
				.startNow()
				.build();
		
		// 使用调度器将作业和trigger关联起来
		scheduler.scheduleJob(jobDetail, trigger);
		
		// 开始调度
		scheduler.start();
	}
	
}
