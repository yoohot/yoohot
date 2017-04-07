package test.filterchain;

public class RifleConnection extends Connection {

	@Override
	public void execute() {
		System.out.println(getName() + ":" + "start...");
	}

}
