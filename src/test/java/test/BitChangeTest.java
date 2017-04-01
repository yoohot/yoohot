package test;

import java.nio.channels.SelectionKey;

import org.junit.Test;

public class BitChangeTest {
	
	@Test
	public void test1(){
		//16:8:1:4                 1<<3==8
		System.out.println(SelectionKey.OP_ACCEPT+":"+SelectionKey.OP_CONNECT+":"+SelectionKey.OP_READ+":"+SelectionKey.OP_WRITE);
		
		int i=SelectionKey.OP_ACCEPT|SelectionKey.OP_ACCEPT&SelectionKey.OP_READ;
		
		System.out.println(i);
		
		
	}

}
