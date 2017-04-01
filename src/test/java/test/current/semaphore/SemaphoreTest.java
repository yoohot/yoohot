package test.current.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	public static void main(String[] args) {
		
		
		Semaphore sema=new Semaphore(5);
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 20; i++) {

			final int no=i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {

					try {
						sema.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("NO:   " + no);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(" end..............." + no);
					sema.release();


				}
			});

		}
		
	threadPool.shutdown();
		
		
		
	}
	
	

}
