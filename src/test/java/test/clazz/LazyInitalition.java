package test.clazz;

class Lazy{
	static final int num=1;
	final static String name="cgl";
	final static TestClass testC=new TestClass();
	static{
		System.out.println("lazy loading ...");
	}
}

public class LazyInitalition {
	
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(Lazy.num);//no
		System.out.println(Lazy.name);//no
		//Class.forName("test.clazz.Lazy");//会立即初始化
		//System.out.println(Lazy.testC);//会立即初始化，构造器也是静态方法
		Class clazz=Lazy.class;//no,初始化被延迟 到静态方法或者非静态常量进行首次引用时才执行
		System.out.println(clazz);
	}

}
