package test.sync;

import java.util.concurrent.TimeUnit;

public class SynchronizedTest  extends Thread{

	private static int i=0;
	
	public synchronized static int  getI(){
		System.out.println("getI metohd:"+i);
		return i;
	}
	public synchronized static void setI(int i){
		System.out.println("set i");
		try {
			TimeUnit.MINUTES.sleep(1l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SynchronizedTest.i=i;
	}
	
	@Override
	public void run() {
          if(i==0){
        	  i=1;
        	  setI(1);
          }
	 getI();
	
	}
	
	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			
				System.out.println("new thread:");
				new SynchronizedTest().start();
			
			
		}
		
		
		
	}
	
	
	
}
