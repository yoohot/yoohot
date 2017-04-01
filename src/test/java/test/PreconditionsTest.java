package test;

import com.google.common.base.Preconditions;

public class PreconditionsTest {
	
	public static void main(String[] args) {
		

		//System.out.println(Preconditions.checkElementIndex(1, 1));
		//System.out.println(Preconditions.checkElementIndex(1, 1, "下表越界"));
 //		System.out.println(Preconditions.checkNotNull(null));
 //	System.out.println(Preconditions.checkNotNull(null, "null ex "));
// 	System.out.println(Preconditions.checkNotNull(null, "null ex %s.%s", "head","tail"));
 //	 Preconditions.checkArgument(1>2);
 	 Preconditions.checkState(1>2);
		
		
	}

}
