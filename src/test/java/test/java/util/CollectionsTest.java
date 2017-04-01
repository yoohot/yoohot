package test.java.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.util.SystemPropertyUtils;

import com.google.common.collect.Lists;

import test.quartz.test1.MyJob1;

public class CollectionsTest {
	
	public static void main(String[] args) {
		
		List<String> list=Arrays.asList("aa", "bb","cc","dd");
		
		int idx = Collections.binarySearch(list, "cc");
		System.out.println(idx);
		
		List<MyJob1> jobs=Lists.newArrayList();
		MyJob1 myJob1 = new MyJob1("aa");
		MyJob1 myJob2 = new MyJob1("bb");
		MyJob1 myJob3 = new MyJob1("cc");
		MyJob1 myJob4 = new MyJob1("aa");
		
		jobs.add(myJob1);
		jobs.add(myJob2);
		jobs.add(myJob3);
		
    idx=Collections.binarySearch(jobs, myJob4);
    System.out.println(idx);
    
    List<String> empty=Collections.emptyList();
    		empty.add("aa");
		System.out.println(empty);
		
		
	}

}
