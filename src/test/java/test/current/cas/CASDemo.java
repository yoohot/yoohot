package test.current.cas;

import java.util.concurrent.CountDownLatch;
/*
 * CAS DEMO: compare-and-swap test 
 * 
 */
public class CASDemo {

	private int value;

	public void setValue(int v) {
		this.value = v;
	}

	public synchronized int getValue() {
		return value;
	}
	
	public synchronized boolean compareAndSwap(int expected,int update){
		
		if(value==expected){
			value=update;
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		CASDemo cas=new CASDemo();
		CountDownLatch latch=new CountDownLatch(10);
		
		for(int i=0;i<10;i++){
				
	          new Thread(new CASJob(cas,latch)).start();
	  }
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(cas.getValue());
	}
	
	
	
	

}

class CASJob implements  Runnable {
    private CASDemo cas;
    
    private CountDownLatch latch;
    
    public CASJob(CASDemo cas,CountDownLatch latch ) {
         this.cas=cas;
         this.latch=latch;
    }
	public void run() {
		
		for(;;){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int value = cas.getValue();
			
			
			boolean swap = cas.compareAndSwap(value, value+1);
			
			System.out.println(swap);
		    if(swap) break;	
		}
		
		latch.countDown();
	}
}
