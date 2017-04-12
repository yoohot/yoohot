package test.patterns.decorate;

public class WearPersonDecorate extends PersonDecorate {

	public WearPersonDecorate() {
	}

	public WearPersonDecorate(Person person){
            setPerson(person);
     }

	@Override
	public void introduceOneSelf() {
		 getPerson().introduceOneSelf();
		other();
	}
	
	public void other(){
		System.out.print(" wear sth. other module.");
	}

}
