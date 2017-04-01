package test.classloader;

class Test{
	static {
		System.out.println("Test class loading");
	}
	public static String s="w";
}

interface face{
	
}

public class ConstructorStatic {

	static {
		System.out.println("hello class loader..");
	}
	public static String s="asd";
	
	public ConstructorStatic() {
         System.out.println("start."+ConstructorStatic.class);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {

		System.out.println("main inside");
		System.out.println(s);
		
		System.out.println(Test.s);
		//或者反射加载
        Class.forName("test.classloader.Test");
        System.out.println(face.class.getSuperclass());
        System.out.println(ConstructorStatic.class.getSuperclass());
 	}
}
