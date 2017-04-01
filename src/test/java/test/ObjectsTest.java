package test;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class ObjectsTest {
	
	public static void main(String[] args) {
		System.out.println(Objects.equal(null, null));
		System.out.println(Objects.equal("sad", 1));
		System.out.println(Objects.equal("ab", "a"+"b"));
		String s=Objects.toStringHelper(Lists.newArrayList("aa","cc","bb")).add("age", 23).add("sex", "nan").toString();
		System.out.println(s);
	}

}
