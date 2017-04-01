package test.generic;

import java.util.Arrays;

public class GenericArrayTest<T> {
	private T t;
	public GenericArrayTest(T t) {
		this.t = t;
	}
	T getT() {
		return t;
	}
	static GenericArrayTest<Integer>[] ints;
	public static void main(String[] args) {
		ints = new GenericArrayTest[] { new GenericArrayTest<Object>(new Object()), new GenericArrayTest<String>("name") };
		System.out.println(Arrays.toString(ints));
		Integer name = ints[1].getT();
		System.out.println(name);
	}

}
