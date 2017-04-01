package test.httpclient;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import test.quartz.test1.MyJob1;

public class JsonPostTest {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		
		String url="http://www.baidu.com";
		HttpClient client=HttpClients.createDefault();
		
		HttpPost post=new HttpPost(url);
		
		List<MyJob1> jobs=Lists.newArrayList(new MyJob1("a", 10, new Date()),new MyJob1("b", 11, new Date()),new MyJob1("c"));
		
		String json=JSON.toJSONString(jobs);
		String param=json;
		System.out.println(json);
		StringEntity entity=new StringEntity(param, Charset.forName("utf-8"));
		entity.setContentEncoding("utf-8");
		entity.setContentType("application/json");
		post.setEntity(entity);
		
		HttpResponse response = client.execute(post);
		
		
		
	}

}
