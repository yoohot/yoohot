package test.patterns.factory;

public class FactoryTest {
	
	public static void main(String[] args) {
		Calculate calculate = DefaultCalculateFactory.factory(args[0]);
		System.out.println(calculate.execute(4, 4));
	}

}
