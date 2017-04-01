package test.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;

public class HttpPostTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		String data="";
		for(int i=0;i<10;i++){
		
		List<NameValuePair> parameters=Lists.newArrayList();
		
		parameters.add(new BasicNameValuePair("tel", "18200000000"));
		parameters.add(new BasicNameValuePair("voice", ""));
		
		HttpClient client=HttpClients.createDefault();
		
		HttpPost post=new HttpPost("http://www.topdiaoyu.com/getMobCode.tran");
		
       HttpEntity entity=new UrlEncodedFormEntity(parameters);
	post.setEntity(entity);
	HttpResponse response = client.execute(post);
	System.out.println(response.getStatusLine().getStatusCode());
	InputStream content = response.getEntity().getContent();
	
	     byte[] b=new byte[content.available()];
		content.read(b, 0, content.available());
		
		data+=new String(b);
		content.close();
	
		}
	
       System.out.println(data);
		
	}
}
