package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.util.Base64Utils;

public class Base64UtilsTest {

	public static String imgEncode(String imgFile) throws Exception {
		File file = new File(imgFile);
		if (file.isFile()) {
			FileInputStream stream = new FileInputStream(file);
			byte[] bytes = null;
			bytes = new byte[stream.available()];
			stream.read(bytes);
			stream.close();
			return Base64Utils.encodeToString(bytes);
			
		}
		return null;
	}
	
	
	public  static void imgDecode(String imgSrcFile,String  destFile) throws IOException{
		System.out.println(imgSrcFile+"----------------src");
		
		byte[] decode = Base64Utils.decode(imgSrcFile.getBytes());
		
		File file=new File(destFile);
		
		
		FileOutputStream stream=new FileOutputStream(file);
		
		stream.write(decode);
		
		stream.close();
		
	}
	
	public static void main(String[] args) throws Exception {
	
		System.out.println("start");
		
		 String imgEncode = imgEncode("D://程广林.jpg");
		 
		 imgDecode(imgEncode, "D://man.png");
		 
		 System.out.println("end");
		
	}
	
	
	
	

}
