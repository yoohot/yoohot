package test.generic;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureTest  implements Comparable<String>{

	@Override
	public int compareTo(String o) {
		
		return this.compareTo(o);
	}
	//public int compareTo(Object o){return 0;}
	
	public int compareTo(Integer i){
		return 0;
	}
	public Object wildcard(List<?> list) {
	  //  list.add(1);//编译错误 
		  Object object = list.get(0);
/*		  	list.add(1);编译器无法通过
			list.add(new Object());*/
		  return object;
	} 
	public void compare(String o){}
	public void compare(Object o){}
	public static void main(String[] args) {
		TypeErasureTest test = new TypeErasureTest();
		List<Number> list=new ArrayList<Number>();
		list.add(1);
		list.add(1.0f);
		List<?> lists=new ArrayList<>();
/*		lists.add(1);
		lists.add(new Object());*/
		Object wildcard = test.wildcard(list);
		System.out.println(wildcard.getClass());
		List<String> [] lss=new ArrayList[12];
	}

}
