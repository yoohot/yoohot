package test;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FastJsonTest {
	
	public static void main(String[] args) {
		List<Map<String, String>> list=Lists.newArrayList();
		
		Map<String, String> map1=Maps.newHashMap();
		map1.put("k1", "v1");
		
		Map<String, String> map2=Maps.newHashMap();
		
		map2.put("k2", "v2");
		
		list.add(map1);
		list.add(map2);
		
		String jsonStr=JSON.toJSONString(list);
		System.out.println(jsonStr);
		
		  list=  JSON.parseObject(jsonStr,new TypeReference<List<Map<String,String>>>(){});
		  Object parse = JSON.parse(jsonStr);
		  list=(List<Map<String, String>>) parse;
		  System.out.println(parse);
		System.out.println(list);
	}

}
