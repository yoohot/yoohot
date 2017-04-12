package test;

public class MainThread {
	
	public static void main(String[] args) {
		String test=test();
		System.out.println(test);
		return;
	}
	
	
	
	public static String test(){
	  
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(;;){
					try {
						Thread.sleep(1000);
						System.out.println("--------");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		t.start();
		
		
		
		return "main test";
	}

}
