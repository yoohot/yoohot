package test.random;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random random1=new Random(47);
		Random random2=new Random(47);
		System.out.println(random1.nextInt());
		System.out.println(random2.nextInt());
		
		System.out.println(System.nanoTime());
	}

}
