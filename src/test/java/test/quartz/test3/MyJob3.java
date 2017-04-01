package test.quartz.test3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob3  implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("..start");
		String name = context.getTrigger().getKey().getName();
		System.out.println("trigger-key"+name);
		System.out.println("...end");
	}

}
