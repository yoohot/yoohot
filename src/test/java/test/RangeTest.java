package test;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class RangeTest {
	
	public static void main(String[] args) {
		
		Range<Integer> range=Range.upTo(10, BoundType.OPEN);
		Range<Integer> range2=Range.downTo(10, BoundType.CLOSED);
		System.out.println(range.containsAll(Ints.asList(8,9,10)));
		System.out.println(range.contains(10));
		System.out.println(range.isConnected(range2));
		
		
	}

}
