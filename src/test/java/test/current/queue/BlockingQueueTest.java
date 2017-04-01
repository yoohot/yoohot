package test.current.queue;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class BlockingQueueTest {
	
	static LinkedBlockingQueue<String> block=new LinkedBlockingQueue<>(1);
	@Test
	public void testPut() throws InterruptedException{
		
         System.out.println("put start..");
         block.put("AA");
         System.out.println("puted A");
         block.put("BB");
         System.out.println("puted B");
	}
	@Test
	public void testTake() throws InterruptedException{
		
		block.put("AA");
		
		String take = block.take();
		System.out.println(take);
		take=block.take();
		System.out.println("end");
	}

}
