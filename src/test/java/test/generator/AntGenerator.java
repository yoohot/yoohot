package test.generator;

import java.util.ArrayList;
import java.util.List;

public class AntGenerator<T,E>  implements Generator<E>{

	private E props;
	private static String name="ant";
	public AntGenerator(E e) {
       this.props=e;
	}
	@Override
	public E next() {
		//System.out.println(name instanceof E);
		System.out.println(props instanceof Object);
		return null;
	}
	
	public static void main(String[] args) {
		List<? extends Number> num=new ArrayList<Integer>();
		List<String> str=new ArrayList<String>();
		System.out.println(num.getClass()==str.getClass());
		AntGenerator<String, Integer> ant=new AntGenerator<String,Integer>(new Integer(2));
		ant.next();
		
	}

}
