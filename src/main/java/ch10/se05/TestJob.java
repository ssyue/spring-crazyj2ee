package ch10.se05;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
	// 设置一个用来判断作业是否正在执行的旗标
	private boolean isRunning = false;

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		if(!isRunning) {
			System.out.println(new Date() + ": 作业被调度。");
			// 使用循环模拟任务执行过程
			for(int i=0; i<100; i++) {
				System.out.println("作业完成度：" + (i+1) + "% …");
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("作业调度结束！");
		} else {
			System.out.println(new Date() + ": 作业正在运行中，此次调度结束");
		}
	}

}
