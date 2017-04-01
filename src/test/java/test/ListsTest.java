package test;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class ListsTest {
	public static void main(String[] args) {
		
		List<Integer> list=Ints.asList(1,4,2,3,6,8,3);
		
		List<List<Integer>> partition = Lists.partition(list, 3);
		System.out.println(partition.size());
		for(List<Integer> l:partition){
			System.out.println(l);
		}
		
		System.out.println(Lists.reverse(list));
		Iterator<Integer> iterator = list.iterator()
		
		;

	}

}
