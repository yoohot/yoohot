package test.quartz.test2;



import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob2  implements Job{
	
	private String name;
	
	private Date birth;
	
	private String age;
	
	

	@Override
	public String toString() {
		return "MyJob2 [name=" + name + ", birth=" + birth + ", age=" + age + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getBirth() {
		return birth;
	}



	public void setBirth(Date birth) {
		this.birth = birth;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println("...job start");
		  String name = context.getJobDetail().getKey().getName();
		  System.out.println(name);
		  System.out.println("...job end");
		
	}

}
