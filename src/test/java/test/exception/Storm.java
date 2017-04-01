package test.exception;

public interface Storm {
	
	void event () throws StormException,BException;
	
	void rain() throws StormException;

}

class StormException extends Exception{}