package test.clazz;

import java.awt.print.Book;

public class TestClass extends  Book{
	
	public static void main(String[] args) throws Exception {
		Class<? super TestClass> superclass = TestClass.class.getSuperclass();
		Object newInstance = superclass.newInstance();//Object
		
		Class<? extends Book> clazz=new TestClass().getClass();
		Book newInstance2 = clazz.newInstance();//Book
	}

}
