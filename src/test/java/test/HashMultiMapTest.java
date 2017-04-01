package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class HashMultiMapTest {
	
	public static void main(String[] args) {
		Multimap<String, String> map=HashMultimap.create();
		
		map.put("a", "a");map.put("a", "b");map.put("a", "a");
		map.put("b", "b");map.put("b", "b");
		map.put(null, "a");map.put(null, null);
		map.put("c", "c");
		
		System.out.println(map.get("a"));
		
		System.out.println(map.get(null).size());
		Collection<String> col = map.asMap().get("c");
		System.out.println(col);
		col=map.asMap().get("a");
		System.out.println(col);
		
		map.remove("c", "c");
        col=map.asMap().get("c");
        System.out.println(col);
        System.out.println(map.get("c"));
        
        System.out.println("--------------------------");
        map=ArrayListMultimap.create();
        
		map.put("a", "a");map.put("a", "b");map.put("a", "a");
		map.put("b", "b");map.put("b", "b");
		map.put(null, "a");map.put(null, null);
		map.put("c", "c");
		
		System.out.println(map.get("a"));
		
		System.out.println(map.get(null).size());
		  col = map.asMap().get("c");
		  col.add("ccccc");
		  System.out.println(map.get("c"));
		System.out.println(col);
		col=map.asMap().get("a");
		System.out.println(col);
		
		map.remove("c", "c");
        col=map.asMap().get("c");
        System.out.println(col);
        System.out.println(map.get("c"));
        
        Map<String, Collection<String>> asMap = map.asMap();
        System.out.println(asMap.getClass().getName());
		
	}

}
