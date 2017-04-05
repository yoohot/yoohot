package test.patterns.factory;

public class AddCalculate implements Calculate {

	@Override
	public int execute(int start,int end) {
		return start+end;
	}

}
