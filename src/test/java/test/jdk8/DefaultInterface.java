package test.jdk8;

interface DefaultMethod{
	
	default void saySmth(){
		System.out.println("this is DefaultMethod's default method saySmth");
	}
	default void say(){
		System.out.println("this is DefaultMethod's default method say");
	}
}

public class DefaultInterface  implements DefaultMethod{
	public static void main(String[] args) {
		DefaultInterface di=new DefaultInterface();
		
		di.say();
		di.saySmth();
	}

}
