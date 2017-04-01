package test.current.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Integer sec = 0;

		Jobs job = new Jobs(sec);
		for (int i = 0; i < 50; i++) {
			FutureTask<Integer> task = new FutureTask<>(job);
			new Thread(task).start();
			sec = task.get();
			System.out.println(sec);
		}
		Thread.sleep(100);
		System.out.println(sec);
	}

}

class Jobs implements Callable<Integer> {

	private Integer sec;

	final ReentrantLock loc = new ReentrantLock();

	public Jobs(Integer sec) {
		this.sec = sec;
	}

	@Override
	public Integer call() throws Exception {

		loc.lock();
		try {
			sec++;
		} finally {
			loc.unlock();
		}
		return sec;
	}

}