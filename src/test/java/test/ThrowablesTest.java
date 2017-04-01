package test;

import java.util.List;

import com.google.common.base.Throwables;

public class ThrowablesTest {
	
	public static void main(String[] args) {
		
		try{
			int i=10/0;
			
		}catch (Exception e ){
			Throwable rootCause = Throwables.getRootCause(e);
			System.out.println(rootCause);
			
			List<Throwable> chain = Throwables.getCausalChain(e);
			System.out.println(chain);
			
			String string = Throwables.getStackTraceAsString(e);
			
			System.out.println(string);
		}finally{
			System.out.println("end..");
		}
		
	}

}
