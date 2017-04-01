package test;

public class ByteMove {

	
	public static void main(String[] args) {
		int i=1;
		int m=2;
		int n=4;
		
		System.out.println(i>>1);
		System.out.println(m>>1);
		System.out.println(n>>1);
		System.out.println(0x1010>>1);
		System.out.println(12>>1);
		System.out.println(1000>>1);
		System.out.println(1<<2);
		System.out.println(2<<3);
		System.out.println(-(-Integer.MAX_VALUE)>>>1);
		System.out.println((-1073741823)<<4);
		System.out.println(-16<<4);
		
		System.out.println(1024^256);
		System.out.println(0xab);
		
		
	}
	
}
