package test.patterns.strategy;

public class ReturnCashAlgorithm implements CashAlgorithm {

	private double threld;

	private double retPrice;

	public ReturnCashAlgorithm(double threld, double retPrice) {
		this.threld = threld;
		this.retPrice = retPrice;
	}

	@Override
	public double algorithm(int num, double price) {
		double total = num * price;
		if (total >= threld) {
			total = total - retPrice;
		}
		return total;
	}

}
