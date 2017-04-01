package test.ftpclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {
	
	private static FTPClient ftp=new FTPClient();

	private static void connect(){
		try {
			ftp.connect("127.0.0.1",21);
            ftp.setControlEncoding("utf-8");
            int reply = ftp.getReplyCode();
            if (FTPReply.isPositiveCompletion(reply)) {  
                if (ftp.login("anonymous", "123456")) {  
                    System.out.println("Successful login!");  
                } else {  
                    System.out.println("fail to login!");  
                }  
            }  
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void disConnect(){
		

		if(ftp.isConnected()){
			try {
				ftp.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public  static void ftpUpload(){
		
		connect();
		
		InputStream in=new ByteArrayInputStream("1234567890".getBytes());
		try {
			ftp.storeFile("ftp\\num.dat", in);
			OutputStream storeFileStream = ftp.storeFileStream("a.dat");
			storeFileStream.write("adbsdare23".getBytes());
			storeFileStream.close();
			ftp.storeUniqueFile(in);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		disConnect();
		
		
		
	}
	
	public static void main(String[] args) {
		FtpUtil ftpUtil=new FtpUtil();
		
		ftpUtil.ftpUpload();
		
		
	}
	
	

}
