package test.current.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author cgl   -   2017年2月21日下午4:31:42  
 *  
 * @description 线程池默认的拒绝策略是ThreadPoolExecutor.AbortPolicy 会抛异常，
 *     而Executers创建的线程池除了cache外，另外两个线程池是链表LinkingBlockingQueue接受任务队列缓存,不会拒绝接受任务。
 *                                       cache线程池会一直创建线程，不会缓存任务队列
 *                                       所以RejectHandler没起作用<br/>
 *       即Executers正常情况下不会拒绝接受任务；
 *                                       
 *
 */
public class ThreadPoolTest {
	
	public static void main(String[] args) {
		
		
		ThreadPoolExecutor pool=new ThreadPoolExecutor(5, 10, 30000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardPolicy());
		
		
		for(int i=0;i<20;i++){
			final int num=i;
			pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                        System.out.format("--------------  "+"%02d"+"  --------------------------\n",num);					
				}
			});
		}
		
		pool.shutdown();
		
		
		
	}

}
