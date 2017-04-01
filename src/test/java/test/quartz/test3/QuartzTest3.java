package test.quartz.test3;

import java.util.concurrent.TimeUnit;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest3 {

	public static void main(String[] args) throws Exception {

		SchedulerFactory factory = new StdSchedulerFactory();

		Scheduler scheduler = factory.getScheduler();

		JobDetail job = JobBuilder.newJob(MyJob3.class).withIdentity("job1", "grp1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("*/3 22 * ? * */3"))
				.withIdentity("trigger1").build();

		scheduler.scheduleJob(job, trigger);

		scheduler.start();

		TimeUnit.SECONDS.sleep(30);
		int jobsExecuted = scheduler.getMetaData().getNumberOfJobsExecuted();
		System.out.println("exec.." + jobsExecuted);

	}

}
