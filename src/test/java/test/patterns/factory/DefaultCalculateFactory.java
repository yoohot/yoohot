package test.patterns.factory;

public class DefaultCalculateFactory {

	public static Calculate factory(String type) {
		Calculate cal = null;
		switch (type) {
		case "add":
			cal = new AddCalculate();
			break;
		case "sub":
			cal = new SubCalculate();
			break;

		default:
			break;
		}

		return cal;

	}

}
