package test.httpclient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;

public class GoTopDiaoyu {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		
		for(;;){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					HttpClient client=HttpClients.createDefault();
					
					HttpUriRequest request=new HttpGet("http://www.topdiaoyu.com/html/sport/sportdetail/MatchDetails.jsp?MATCH_ID=01147810158749534176");
					HttpResponse response=null;
					try {
						response = client.execute(request);
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println(response.getStatusLine().getStatusCode());
					
				}
			}).start();
		}
		
		
		
		
	}

}
