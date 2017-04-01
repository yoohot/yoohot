package test.current.reentrantLock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 
 * @author cgl   -   2017年2月19日下午3:56:10  
 *  
 * @description 写的时候其他线程不能读，没有写锁的时候可以并发读
 *
 */
public class ReentrantReadWriteLockTest {

	public static void main(String[] args) {

		ReadWriteLockDemo rw=new ReadWriteLockDemo();
		for(int i=0;i<9;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					rw.read();
				}
			}, "read"+i).start();
			
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				rw.write();
			}
		}, "WRITE").start();
		
		
		
	}
}

class ReadWriteLockDemo {

	private int num = 1;

	final static ReadWriteLock lock = new ReentrantReadWriteLock();

	public void read() {

		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " : " + num);

		} finally {
			lock.readLock().unlock();
		}
	}

	public void write() {

		lock.writeLock().lock();
		try {
			Thread.sleep(1000);
			System.out.println("write thread");
			this.num = new Random().nextInt(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}

	}

}
