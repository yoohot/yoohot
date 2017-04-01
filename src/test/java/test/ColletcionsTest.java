package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColletcionsTest {

	
	
	public static void main(String[] args) {
		List<Object> list = Arrays.asList(new Snow(),new Ray(),new Shadow());
		Arrays.<Snow>asList(new Flower());
		
		List<Snow> snows=Arrays.asList(new Flower(),new Shadow());
	//	snows.add(new Flower());
		
		List<Ray> rays=new ArrayList<Ray>();
				rays.addAll(Arrays.asList(new Flower(),new Shadow()));
				rays.add(new Ray());
		//list=snows;
	}
	
}


class Snow{}

class Flow extends Snow{}

class Ray extends Snow{}

class Flower extends Ray{}
class Shadow extends Ray{}