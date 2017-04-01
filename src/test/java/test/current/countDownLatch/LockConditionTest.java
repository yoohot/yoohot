package test.current.countDownLatch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {

	public static void main(String[] args) {
		Cond cond = new Cond();

		new Thread(new Runnable() {
			@Override
			public void run() {
				cond.loopA();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				cond.loopC();
			}
		}).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				cond.loopB();
			}
		}).start();


	}

}

class Cond {

	private Lock lock = new ReentrantLock();
	private Condition cond1 = lock.newCondition();
	private Condition cond2 = lock.newCondition();
	private Condition cond3 = lock.newCondition();

	private int flag = 1;

	private int loop = 0;
	int num=3;

	public void loopA() {

		lock.lock();
		try {
			for (int i = 0; i < 1; i++) {
				if (flag == 1) {
					flag++;
					cond2.signal();
				}else{
					cond1.await();
				}
				System.out.println("AAA");
			}

		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public void loopB() {

		lock.lock();
		try {
			for (int i = 0; i < 1; i++) {
				if (flag == 2) {
					flag++;
					cond3.signal();
				}else{
					cond2.await();
				}
				System.out.println("BBB");
			}
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public void loopC() {

		lock.lock();
		try {
			for (int i = 0; i < 1; i++) {
				if (flag == 3) {
					flag=1;
					cond1.signal();
				}else{
					cond3.await();
				}
				System.out.println("CCC");
			}
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

}