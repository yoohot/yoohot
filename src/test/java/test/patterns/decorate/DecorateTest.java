package test.patterns.decorate;

public class DecorateTest {
	
	public static void main(String[] args) {
		Chinese cgl=new Chinese();
		
		WearPersonDecorate wear=new WearPersonDecorate(cgl);
		PantsPersonDecorate pants=new PantsPersonDecorate(wear);
		
		
		wear.introduceOneSelf();
		
		pants.introduceOneSelf();
		
	}

}
