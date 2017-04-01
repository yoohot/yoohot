package test.current.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) throws Exception {
		final int count = 5;
		CountDownLatch latch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			Thread t = new Thread(new Job(latch));
			t.setName(i + "");
			t.start();
		}

		latch.await();
		for (int i = 0; i < count; i++) {
			System.out.println("main thread:" + i);
		}

	}

	private static class Job implements Runnable {
		private CountDownLatch latch;

		private Job(CountDownLatch l) {
			this.latch = l;
		}

		@Override
		public void run() {

			System.out.println("jobs name:" + Thread.currentThread().getName() + "before count down");

			this.latch.countDown();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("jobs name:" + Thread.currentThread().getName() + "after count down");

		}

	}

}
