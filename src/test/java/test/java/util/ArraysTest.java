package test.java.util;

import java.util.Arrays;

import test.quartz.test1.MyJob1;

public class ArraysTest {
	
	public static void main(String[] args) {
		
		
		MyJob1 myJob1 = new MyJob1();
		MyJob1 myJob2 = new MyJob1();
		MyJob1 myJob3 = new MyJob1();
		MyJob1[] jobs=new MyJob1[]{myJob1,myJob2,myJob3};
	   MyJob1[] jobs_=new MyJob1[]{myJob1,myJob2,myJob3};
		MyJob1[] job1s = Arrays.copyOf(jobs, 3);
		
		jobs[0].setName("chengguanglin");
		
		System.out.println(jobs[0].hashCode());
		System.out.println(job1s[0].hashCode());
		System.out.println(job1s[0]==jobs[0]);
		System.out.println(job1s[0].getName());
		
		System.out.println(Arrays.deepEquals(jobs, jobs_));
		System.out.println(Arrays.deepToString(job1s));
		System.out.println(Arrays.toString(job1s));
		
		Double[] dobs={1.0,2.0,3.0};
		Arrays.fill(dobs, 2.0);
		System.out.println(Arrays.deepToString(dobs));
		
	}

}
