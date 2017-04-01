package test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class JoinerTest {

	public static void main(String[] args) {
		Joiner joiner=Joiner.on(",").skipNulls();
		String string = joiner.join("a", null, new JoinerTest(),"bb");
		System.out.println(string);
		
		joiner=Joiner.on(",").useForNull("NULL");
		string=joiner.join("a", null, new JoinerTest(),"bb");
		System.out.println(string);
		string=joiner.join("cc","dd");
		System.out.println(string);
		
		String join = joiner.join(Lists.newArrayList());
		System.out.println(join+"----");
		
		
	}
}
