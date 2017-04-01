package test.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeArray {
	public static void main(String[] args) {

		List<String>[] lists = new ArrayList[2];

		Object[] objs = lists;
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(47);
		objs[0] = ints;
		objs[1] = new Object();

		System.out.println(lists[0]);
		List<String> list = lists[0];
		System.out.println(lists[0].get(0));
		List<String> s = new ArrayList<String>();
		Object obj = s;
		List<Integer> i = (List<Integer>) obj;
		i.add(47);
		System.out.println(i);
		System.out.println(s.get(0));

	}

}
