package test;

public class BooleanTest {

	
	
	public static void main(String[] args) {
		System.setProperty("name", "true");
		System.out.println(Boolean.getBoolean("name"));
		
		long x=(long)(Integer.MAX_VALUE)+1;
		System.out.println(x);
		
		System.out.println("abc".getBytes().length);
		System.out.println("程广林。".getBytes().length);
		System.out.println(Byte.SIZE);
		
		
	}
}
