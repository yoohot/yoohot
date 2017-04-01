package test.current.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
			@Override
			public void run() {
				
				System.out.println("barrier start...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("...barrier end");
			}
		});

		test(barrier);
	}

	private static void test(CyclicBarrier barrier) {
		final int count = 10;

		for (int i = 0; i < count - 1; i++) {
			Thread t = new Thread(new Job(barrier));
			t.setName(i + "");
			t.start();
		}
		try {
			barrier.await();
		} catch (InterruptedException e) {
		} catch (BrokenBarrierException e) {
		}
		for (int i = 0; i < count; i++) {
			System.out.println("main thread" );
		}
	}

	private static class Job implements Runnable {

		private CyclicBarrier barrier;

		public Job(CyclicBarrier b) {
			this.barrier = b;
		}

		@Override
		public void run() {
			System.out.println("jobs name:" + Thread.currentThread().getName() + "before await");
			try {

				barrier.await();
			} catch (InterruptedException e) {
			} catch (BrokenBarrierException e) {
			}

			System.out.println("jobs name:" + Thread.currentThread().getName() + "after await");

		}

	}

}
