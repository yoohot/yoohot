package test.quartz.test1;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzTest1 {

	public static void main(String[] args) throws Exception {

		JobDetail detail = JobBuilder.newJob(MyJob1.class).withIdentity("job1", "grp1").build();
		
		Date startTime = DateBuilder.evenMinuteDate(new Date());
		Trigger trigger=TriggerBuilder.newTrigger().forJob("job1", "grp1").startAt(startTime).build();
		
		SchedulerFactory factory=new StdSchedulerFactory();
		
		Scheduler scheduler=factory.getScheduler();
		
		scheduler.scheduleJob(detail, trigger);
		
		
		scheduler.start();
		
		
		
		
	}

}
