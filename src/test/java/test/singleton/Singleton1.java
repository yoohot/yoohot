package test.singleton;

/**
 * 
 * @author cgl - 2016年11月10日下午4:41:48
 * 
 * @description 单利 双检索
 *
 */
public class Singleton1 {

	private volatile static Singleton1 instance;

	public static Singleton1 getInstance() {

		if (instance == null) {//1检
             synchronized (Singleton1.class) {
            	 if(instance==null)//2检
            	 instance=new Singleton1();
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton1 singleton=Singleton1.getInstance();
		System.out.println(singleton);
		Singleton1 singleton1=Singleton1.getInstance();
		System.out.println(singleton);
		System.out.println(singleton==singleton1);
		System.out.println(123);
		
	}

}
