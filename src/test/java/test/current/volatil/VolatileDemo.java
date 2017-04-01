package test.current.volatil;

public class VolatileDemo {
	
	
	public static void main(String[] args) {
		
		Job job=new Job();
		
		new Thread(job).start();
		
		while(true){
			// 1 synchronized(Job.class){
				if(job.isFlag()){
					System.out.println("....main...");
					break;
			//	}
			}
		}
	}
}



class   Job implements Runnable{

	//2 volatile
	private volatile boolean flag=false;
	@Override
	public void run() {

		System.out.println("run ...");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	
		flag=true;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
}
