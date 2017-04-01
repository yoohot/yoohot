package test;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str1 = RandomStringUtils.random(10);
		System.out.println(new String(str1.getBytes(),CharEncoding.UTF_8));
		str1=RandomStringUtils.random(4, '1','2','4');
		System.out.println(str1);
		str1=RandomStringUtils.random(10, true, true);
		System.out.println(str1);
//		str1=RandomStringUtils.random(5, 0, 20, false, true);
//		System.out.println(str1);
		str1=RandomStringUtils.randomAlphabetic(5);
		System.out.println(str1);
		str1=RandomStringUtils.randomAlphanumeric(5);
		System.out.println(str1);
		str1=RandomStringUtils.randomAscii(5);
		System.out.println(str1);
		str1=RandomStringUtils.randomNumeric(5);
		System.out.println(str1);
	}

}
