package test.patterns.factory;

public class SubCalculate implements Calculate {

	@Override
	public int execute(int start, int end) {
		
		if(end==0) 
			throw new RuntimeException("除数不能为0");
		
		return start/end;
	}

}
