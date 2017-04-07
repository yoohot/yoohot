package test.patterns.strategy;

public class CashContext {

	private CashAlgorithm algorithm;

	public CashContext(String way) {
		switch (way) {
		/*
		 * case "normal": algorithm=new NormalCashAlgorithm(); break;
		 */
		case "rebate":
			algorithm = new RebateCashAlgorithm(0.8);
			break;
		case "return":
			algorithm = new ReturnCashAlgorithm(500, 100);
			break;

		default:
			algorithm = new NormalCashAlgorithm();
			break;
		}

	}

	public double execute(int num, double price) {
		return algorithm.algorithm(num, price);
	}

}
