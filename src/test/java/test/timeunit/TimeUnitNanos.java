package test.timeunit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class TimeUnitNanos {
	
	@Test
	public void test1() throws InterruptedException{
		
		System.out.println(TimeUnit.DAYS.toNanos(1));//纳秒
		System.out.println(TimeUnit.DAYS.toMicros(1));//毫秒
		System.out.println(24*60*60*1000l);//微妙
		
		ReentrantLock lock=new ReentrantLock();
		Condition cond = lock.newCondition();
		
		cond.awaitNanos(1000);//纳秒
		
	}

}
