package test.filterchain;

public abstract class Connection implements Wrapper {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void execute();
}
