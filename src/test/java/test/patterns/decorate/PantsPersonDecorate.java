package test.patterns.decorate;

public class PantsPersonDecorate extends PersonDecorate {

	public PantsPersonDecorate() {

	}

	public PantsPersonDecorate(Person person) {
		setPerson(person);
	}

	@Override
	public void introduceOneSelf() {
       getPerson().introduceOneSelf();
		pants();

	}

	public void pants() {
		System.out.print("pants oneself. other module.");
	}
}
