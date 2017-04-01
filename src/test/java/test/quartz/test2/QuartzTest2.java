package test.quartz.test2;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest2 {

	public static void main(String[] args) throws Exception {
		
		SchedulerFactory factory=new StdSchedulerFactory();
		
		Scheduler scheduler=factory.getScheduler();
		
		
		Date runTime= DateBuilder.nextGivenSecondDate(null, 10);
		
		JobDetail job1=JobBuilder.newJob(MyJob2.class).withIdentity("job1", "grp1").build();

		Trigger trigger1=TriggerBuilder.newTrigger().withIdentity("trigger1", "grp1").startAt(runTime).build();
		
		//scheduler.scheduleJob(job1, trigger1);		
		scheduler.scheduleJob(job1, trigger1);		
		
		JobDetail job2=JobBuilder.newJob(MyJob2.class).withIdentity("job2", "grp1").build();
		
		Trigger trigger2=TriggerBuilder.newTrigger().withIdentity("trigger2", "grp1").withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(5, 3)).build();
		
		scheduler.scheduleJob(job2, trigger2);		
		
		
		
		scheduler.start();
		
		int num = scheduler.getMetaData().getNumberOfJobsExecuted();
		System.out.println("exe.."+num);
		

		TimeUnit.SECONDS.sleep(30l);
		
		scheduler.shutdown();
		
		num = scheduler.getMetaData().getNumberOfJobsExecuted();
		System.out.println("exe.."+num);
		
		

	}

}
