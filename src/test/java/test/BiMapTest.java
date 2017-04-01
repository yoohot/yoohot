package test;

import com.google.common.base.Objects;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {
	
	public static void main(String[] args) {
		BiMap<String, String> bimap=HashBiMap.create();
		
		bimap.put("11", "11");
		bimap.put("12", "21");
		bimap.put("13", "31");
		bimap.put("14", "41");
		
		System.out.println(bimap.get("12")+"---"+bimap.inverse().get("21"));
		
		BiMap<String,String> inverse = bimap.inverse();
		System.out.println(Objects.equal(inverse, bimap));
		
		System.out.println(bimap.get("12"));
		System.out.println(bimap.get("21"));
		System.out.println(inverse.hashCode());
		System.out.println(bimap.hashCode());
		BiMap<String, String> b1=bimap;
		BiMap<String, String> b2=bimap;
		System.out.println(b1==b2);
		
		
		
	}

}
