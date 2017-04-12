package test.patterns.decorate;

public abstract class PersonDecorate implements Person {

	private Person person;

	public PersonDecorate() {
	}
	
	
	@Override
	public void introduceOneSelf() {
          person.introduceOneSelf();		
	}
	
	

	public PersonDecorate(Person person) {
		this.person = person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Person getPerson(){
		return person;
	}

}
