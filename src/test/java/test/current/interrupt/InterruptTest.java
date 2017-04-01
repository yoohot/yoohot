package test.current.interrupt;

import java.io.File;

public class InterruptTest {
	
	public static void main(String[] args) throws InterruptedException  {
		
		DoInterruptedJob job=new DoInterruptedJob();
		
		
		
		Thread t=new Thread(job);
		t.start();
		Thread.sleep(9000);
		t.interrupt();
		
		
	}

}

class DoInterruptedJob implements Runnable {

	final String path0 = "D:\\视频教程";

	private void readFiles(String path) throws IllegalAccessException, InterruptedException {

		File file = new File(path);

		if (file == null)
			throw new IllegalAccessException("目录不存在");

		if (file.isFile()) {
			System.out.println(file.getAbsolutePath()+file.getName());
			return;
		}

		File[] files = null;
		if (file.isDirectory()) {
			if (Thread.currentThread().isInterrupted()) {
				throw new InterruptedException("取消遍历目录");
			}
			files = file.listFiles();
		}
		if (files != null && files.length > 0) {
			for (File f : files) {
				readFiles(f.getAbsolutePath());
			}
		}
	}

	public void run() {

		try {
			readFiles(path0);
		} catch (IllegalAccessException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}