package test.intern;

public class StringInternTest {
	
	public static void main(String[] args) {
		
		String s="abc";
		
		String a="a";
		String bc="bc";
		
		String t="a"+"bc";
		
		String st=a+bc;
		
		System.out.println("s==t"+(s==t));
		System.out.println("s==st"+(s==st));
		System.out.println("t==st"+(t==st));
		System.out.println("s==st.intern()"+(s==st.intern()));
		System.out.println("t==st.intern()"+(t==st.intern()));
		
		
	}

}
