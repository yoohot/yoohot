package test.httpclient;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.CharBuffer;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;

public class HelloWorld {

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

		HttpClient httpClient = HttpClients.createDefault();

		URI uri=new URIBuilder("http://www.topdiaoyu.com/html/sport/sportdetail/sportlist.jsp").setParameter("wd", "dsadshaidsoidhsaidhasiodadashdoidhaosd").build();
		
		
		HttpGet get = new HttpGet(uri);
		HttpResponse httpResponse = httpClient.execute(get);
		
		
		System.out.println("httpClient-"+httpClient);
		StatusLine statusLine = httpResponse.getStatusLine();
		System.out.println("httpResponse-" + httpResponse);
		System.out.println(statusLine);
		int code = statusLine.getStatusCode();
		System.out.println("code-" + code);

		Header[] allHeaders = httpResponse.getAllHeaders();
		for (Header header : allHeaders) {
			System.out.println("header-" + header);
		}
		HttpEntity entity = httpResponse.getEntity();
		System.out.println("entity-" + entity);

		
		
		Locale locale = httpResponse.getLocale();
		System.out.println(locale);

		HttpParams params = httpResponse.getParams();
		System.out.println("params-" + params);
		ProtocolVersion version = httpResponse.getProtocolVersion();
		System.out.println("version-" + version);
 	InputStream inputStream = entity.getContent();
		
		InputStreamReader reader=new InputStreamReader(inputStream);
 
        char[] chrs=new char[10000];
		int read = reader.read(chrs);
		System.out.println(read);
		
		System.out.println("delete"+new String(chrs));
		
		reader.close(); 
	
	}

}
