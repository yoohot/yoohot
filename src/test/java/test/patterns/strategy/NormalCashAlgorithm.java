package test.patterns.strategy;

public class NormalCashAlgorithm implements CashAlgorithm{

	@Override
	public double algorithm(int num, double price) {
		return num*price;
	}

}
