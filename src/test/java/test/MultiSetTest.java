package test;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset.Entry;

public class MultiSetTest {
	
	public static void main(String[] args) {
		  
	   HashMultiset<String>set=HashMultiset.create();
	   
	   set.add("aabbcc");
	   set.add("bbccdd");
	   set.add("ccddee");
	   set.add("aabbcc");
	   set.add("aabbcc");
	   set.add("ccddee");
	   set.add(null);
	   set.add(null, 3);
	   
	   System.out.println(set.contains("aabbcc"));
	   System.out.println(set.contains("ccddee"));
	   System.out.println(set.contains(null));
	   System.out.println(set.count("ccddee"));
	   System.out.println(set.count(null));
	   System.out.println(set.count("aabbcc"));
	   
	   System.out.println(set.add("aabbcc", 10));
	   System.out.println(set.count("aabbcc"));
	   
	   Iterator<String> iterator = set.iterator();
	   while(iterator.hasNext()){
		   System.out.println(iterator.next());
	   }
	   
	   System.out.println(set.elementSet().size());
	   System.out.println(set.size());
	  // set.remove(null,10);
	   System.out.println(set.contains(null));
	   
	   Set<Entry<String>> entrySet = set.entrySet();
	   for(Entry<String> entry:entrySet){
		   System.out.println(entry.getElement()+":"+entry.getCount()+"---");
	   }

		
	}

}