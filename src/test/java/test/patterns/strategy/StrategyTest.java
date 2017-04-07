package test.patterns.strategy;

public class StrategyTest {
	
	public static void main(String[] args) {
		CashContext context=new CashContext("rebate");
		double ret = context.execute(2, 100);
		System.out.println(ret);
	}

}
