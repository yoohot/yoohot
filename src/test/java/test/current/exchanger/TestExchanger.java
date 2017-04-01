package test.current.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class TestExchanger {

	private static final class Producer implements Runnable {

		private Exchanger<List<Integer>> exchanger;
		
		private List<Integer> list=new ArrayList<>();

		private Producer(Exchanger<List<Integer>> exchanger) {
			this.exchanger = exchanger;
		}

		@Override
		public void run() {
			
			list.add(new Random().nextInt(100));
			list.add(new Random().nextInt(100));
			list.add(new Random().nextInt(100));
			list.add(new Random().nextInt(100));
			list.add(new Random().nextInt(100));

			try {
				exchanger.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static final class Consumer implements Runnable {

		private Exchanger<List<Integer>> exchanger;
		
		private List<Integer> list;

		private Consumer(Exchanger<List<Integer>> exchanger) {
			this.exchanger = exchanger;
		}
		@Override
		public void run() {
			try {
				list=exchanger.exchange(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(list);
		}

	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Exchanger<List<Integer>> exchanger=new Exchanger<>();
		
		new Thread(new Consumer(exchanger)).start();
		Thread.sleep(10);
		new Thread(new Producer(exchanger)).start();
		
	}

}
