package test.current.executor;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class ForkJoinTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ForkJoinDemo demo=new ForkJoinDemo(0l, 1000000000l);
		
		ForkJoinPool pool=new ForkJoinPool();
		
		ForkJoinTask<Long> result = pool.submit(demo);
		Long f = result.get();
		System.out.println(f);
		pool.shutdown();

	}
	
	@Test
	public void test2(){
		Instant start = Instant.now();
		
		Long sum = LongStream.rangeClosed(0L, 50000000000L)
							 .parallel()
							 .reduce(0L, Long::sum);
		
		System.out.println(sum);
		
		Instant end = Instant.now();
		
		System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//1536-8118
	}
	@Test
	public void test3(){
		Instant now = Instant.now();
		System.out.println(System.currentTimeMillis());
		System.out.println(Instant.now());///*.atOffset(ZoneOffset.of("+7")*/));
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		System.out.println(Clock.system(ZoneId.of("+7")).instant());
		System.out.println(Duration.between(now, Instant.now()).toHours());
	}

}

class ForkJoinDemo extends RecursiveTask<Long> {

	Long start;
	Long end;

	public ForkJoinDemo(Long start, Long end) {
		this.start = start;
		this.end = end;
	}

	final int threshold = 10000;

	@Override
	protected Long compute() {

		if (end - start > threshold) {
			Long num = 0l;
			for (Long i = start; i <= end; i++) {
				num += i;
			}

			return num;
		} else {

			ForkJoinDemo left = new ForkJoinDemo(start, (start + end) / 2);
			ForkJoinDemo right = new ForkJoinDemo(start, (start + end) / 2 + 1);

			left.fork();
			right.fork();
			return left.join() + right.join();
		}

	}

}
