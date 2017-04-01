package test.quartz.test1;

import java.util.Comparator;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob1 implements Job,Comparable<MyJob1>{
	private String name;
	
	private int age;
	
	private Date birth;
	
 

	public MyJob1(String name, int age, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
	}



	@Override
	public String toString() {
		return "MyJob1 [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void execute(JobExecutionContext context) throws JobExecutionException {

		  System.out.println("job start ... ");
		  System.out.println(context.getJobDetail().getJobClass().getName());
		  System.out.println(context.getResult());
		  System.out.println(context);
		  System.out.println("...job  end");
		
	}



	public MyJob1() {
		super();
	}



	public MyJob1(String name) {
		super();
		this.name = name;
	}



	@Override
	public int compareTo(MyJob1 o) {
		System.out.println(getName()+"::::"+o.getName());
		return getName().compareTo(o.getName());
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Date getBirth() {
		return birth;
	}



	public void setBirth(Date birth) {
		this.birth = birth;
	}




}
