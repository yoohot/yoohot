package test.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LambdaTest {

	static void test1() {
		System.out.println("test 1 ()");
		ArrayList<String> strs = new ArrayList<>(Arrays.asList("d", "2", "a", "e", "c", "b"));
		System.out.println(strs);
		Collections.sort(strs, (String a, String b) -> {
			return a.compareTo(b);
		});
		System.out.println(strs);
	}

	static void test2() {
		System.out.println("test 2 ()");
		ArrayList<String> strs = new ArrayList<>(Arrays.asList("d", "2", "a", "e", "c", "b"));
		System.out.println(strs);
		Collections.sort(strs, (String a, String b) -> a.compareTo(b));
		System.out.println(strs);
	}

	static void test3() {
		System.out.println("test 3 ()");
		ArrayList<String> strs = new ArrayList<>(Arrays.asList("d", "2", "a", "e", "c", "b"));
		/*
		 * ArrayList<Book> books=new ArrayList<>(); books.add(new Book());
		 * books.add(new Book()); books.add(new Book());
		 */
		System.out.println(strs);
		Collections.sort(strs, (a, b) -> a.compareTo(b));
		System.out.println(strs);
	}

	public static void main(String[] args) {
		test1();
		
		test2();
		
		test3();
	}

}
