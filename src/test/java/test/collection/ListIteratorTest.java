package test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	
	public static void main(String[] args) {
		
		List<String> strs=new ArrayList<String>();
		strs.addAll(Arrays.asList("aa","cc","ee","bb","dd"));
		
		ListIterator<String> iterator = strs.listIterator();
		int i=0;
		while(iterator.hasNext() && i<8){
			System.out.print(iterator.nextIndex());
			System.out.print(iterator.previousIndex());
			System.out.print(iterator.next());
			//System.out.print(iterator.previous());
			System.out.println();
			i++			;
		}
		//   | V | V | V |   //“|”表示指针的当前位置和将移动到的位置
		
		iterator=strs.listIterator(2);
		while(iterator.hasNext()){
			System.out.print(iterator.nextIndex());
			System.out.print(iterator.next());
			System.out.print(iterator.previousIndex());
			System.out.println();
		}
		
		
	}

}
