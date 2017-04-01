package test.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author cgl   -   2016年12月29日下午10:22:47  
 *  
 * @description :泛型数组，由于泛型类型擦除，泛型只是在编译器（生成字节码）时做类型安全校验，在运行时不存在泛型痕迹了。
 * 所以
 * List<String>[] strs=new ArrayList[2];是正确的，
 *
 * @param <T>
 */

public class GenericArray <T>{
	private GenericArray<T>[] array;
	
	public GenericArray(int sz) {
         array=(GenericArray<T>[]) new GenericArray[sz];
	}
	
	public GenericArray<T>[] getArray(){
		return array;
	}
	
	public static void main(String[] args) {
		/*GenericArray<Integer> ga=new GenericArray<>(2);
		//Integer[] array2 = ga.getArray();
		List<String> list=new ArrayList<String>();
		((ArrayList)list).add(1); 
		System.out.println(list.get(0));*/
		List<String>[] lists=(List<String>[])new ArrayList[2];
		Object[] objs=lists;
		objs[0]=new String();
		System.out.println(lists[0].get(0));
		
		
	}

}
