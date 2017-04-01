package test.exception;

public abstract class Inning{
	
	public void event() throws AException,BException{
		System.out.println("Inning method");
	}
	
	public abstract void  abBat() throws BException;


}
class AException extends Exception{}
class BException extends AException{}

class CException extends BException{}