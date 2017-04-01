package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import test.quartz.test1.MyJob1;
import test.quartz.test2.MyJob2;

public class BeanUtilsTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		MyJob1 job=new MyJob1();
		
		job.setAge(10);
		job.setBirth(new Date()); job.setName("jerry");
		
		MyJob2 job1=new	MyJob2();
		BeanUtils.copyProperties(job, job1);
				
				   System.out.println(job1);
				Method method = BeanUtils.findMethod(job.getClass(), "getAge");
			 
				Object object = method.invoke(job);
				System.out.println(object);
		
	}

}
