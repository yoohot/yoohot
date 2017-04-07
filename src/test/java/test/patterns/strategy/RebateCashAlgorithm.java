package test.patterns.strategy;

public class RebateCashAlgorithm implements CashAlgorithm {
	
	private double rebate;
	
	public RebateCashAlgorithm(double rebate) {
		this.rebate=rebate;
	}

	@Override
	public double algorithm(int num, double price) {
		return num*price*rebate;
	}

}
