package test.enhancer;

import java.lang.reflect.Field;

import net.sf.cglib.proxy.Enhancer;

public class EnhancerDemo {

	public void test() {

		System.out.println("hello Enhancer");
	}

	private void canReach() {
		System.out.println("yes i can");
	}

	public static void main(String[] args) throws Exception {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(EnhancerDemo.class);
		enhancer.setCallback(new MethodInteceptorImpl());
		EnhancerDemo demo = (EnhancerDemo) enhancer.create();
		demo.test();
		demo.canReach();
		
		
		Class cache=Integer.class.getDeclaredClasses()[0];
		Field myCache=cache.getDeclaredField("cache");
		myCache.setAccessible(false);
		Integer[] newCache=(Integer[]) myCache.get(cache);
		newCache[132]=newCache[133];
		int a=2;
		int b=a+a;
		System.out.printf("%d +%d =%d",a,a,b);
				

	}

}
