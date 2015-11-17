package ch10.se05;

import org.junit.Test;
import org.quartz.SchedulerException;

public class QuartzTest {
	
	@Test
	public void testQuartz() throws SchedulerException {
		MyQuartzServer.startScheduler();
		try {
			Thread.sleep(5 * 60 * 1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
