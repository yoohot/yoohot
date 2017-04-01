package test.current.copyOnWrite;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
/**
 * 
 * @author cgl   -   2017年2月19日下午3:57:51  
 *  
 * @description copyonwirte 在add的时候加了lock保证只有一个线程写，线程安全
 *
 */
public class CopyOnWriteArrayListTest {

	public static void main(String[] args) throws InterruptedException {

		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		CountDownLatch latch = new CountDownLatch(40);

		Jobs job = new Jobs(list, latch);
		for (int i = 0; i < 40; i++) {
			new Thread(job).start();
		}
		latch.await();
		System.out.println(list.size());
	}

}

class Jobs implements Runnable {

	CopyOnWriteArrayList<Integer> list;
	CountDownLatch latch;

	public Jobs(CopyOnWriteArrayList<Integer> list, CountDownLatch latch) {

		this.latch = latch;
		this.list = list;
	}

	@Override
	public void run() {
		list.add((new Random().nextInt(40)));

		latch.countDown();

	}

}
