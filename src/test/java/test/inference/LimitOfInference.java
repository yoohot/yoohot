package test.inference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LimitOfInference<F> {
	
	static <T> List<T> list(){
		return new ArrayList<T>();
	}
	static void  use(List<HashMap<String,String>> list){
		List<? extends Map>  m=new ArrayList<>();
		System.out.println(list.getClass());
	}
	public static void main(String[] args) {
		System.out.println(list().getClass());
		List<String> list=list();
		System.out.println(list.getClass());
		use(list());//对于方法入参是不会类型推断的，直接Object，可以显示指明类型
		use(LimitOfInference.<HashMap<String,String>>list());//显示指明类型
		
		List<Map<String, String>>lm=list();//类型参数推断只对赋值操作有效**********
		use(new ArrayList<HashMap<String, String>>());
	}

}
