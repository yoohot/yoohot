package test.exception;

public class StormInning extends Inning implements Storm{

	@Override
	public void rain(){
		// TODO Auto-generated method stub
		
	}
	@Override
	public void event() {
		try {
			super.event();
		} catch(RuntimeException e1){
			
		}catch (AException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void abBat() {
		// TODO Auto-generated method stub
		
	}


}
