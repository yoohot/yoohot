package test;

import java.util.Map;

import com.google.common.base.Splitter;

public class SpliterTest {
	
	public static void main(String[] args) {
	String s=",, ,1,2,3";
		
		Iterable<String> iterable = Splitter.on(",").trimResults().omitEmptyStrings().limit(2).split(s);
		for(String s0 :iterable) System.out.println(s0);
		System.out.println("=====");
		iterable=Splitter.onPattern("\\d+").split(s);
		for(String s0 :iterable) System.out.println(s0);
		System.out.println("=====");
		iterable=Splitter.fixedLength(2).omitEmptyStrings().split("12345");
		for(String s0 :iterable) System.out.println(s0);
		System.out.println("=====");
		iterable=Splitter.on(",").on(":").omitEmptyStrings().split("1:2,2,:3");
		for(String s0 :iterable) System.out.println(s0);
		System.out.println("=====");
		Map<String, String> map = Splitter.on(",").withKeyValueSeparator(":").split("1:2,k:v");
		for(Map.Entry<String, String> s0 :map.entrySet()) System.out.println(s0.getKey()+":"+s0.getValue());//@Beta
	
		
	}

}
