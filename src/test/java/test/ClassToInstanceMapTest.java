package test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

public class ClassToInstanceMapTest {
	
	public static void main(String[] args) {
		ClassToInstanceMap<Number> map=MutableClassToInstanceMap.create();
		
		map.put(Number.class, 12);
		
		map.put(int.class, 122);
		
		map.put(Integer.class, 12);
		
		map.put(Integer.class, 100);
		
		map.putInstance(Float.class, 12.00f);
		
		System.out.println(map.get(Integer.class));
		System.out.println(map.get(Number.class));
		System.out.println(map.get(int.class));
		System.out.println(map.getInstance(int.class));
		System.out.println(map.getInstance(Float.class));
		
		ClassToInstanceMapTest test=new ClassToInstanceMapTest();
		  test.getClass();
	}

}
