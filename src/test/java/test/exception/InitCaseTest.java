  package test.exception;

public class InitCaseTest {
	
	
	public static void thrw() throws IllegalAccessException{
		throw new IllegalAccessException();
	}

	public static void caser() throws Throwable{
		try {
			thrw();
		} catch (IllegalAccessException e) {
e.printStackTrace();
System.out.println("\n--------------------------\n");
          throw new Exception().initCause(e);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		try {
			caser();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------------------------\n");
			System.out.println(e.getCause());
			System.out.println("--------------------------\n");
			e.getCause().printStackTrace();
		}
	}
}
