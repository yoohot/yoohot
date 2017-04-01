package test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;

public class CharMatcherTest {
	
	public static void main(String[] args) {
		String s="   *a*ds@343F南海ec.,\nssd ad爱s /nd  sa  sa* 76chong中3；A晒得 ";
		String from = CharMatcher.DIGIT.retainFrom(s);
		System.out.println(from+"digit");
		from=CharMatcher.BREAKING_WHITESPACE.removeFrom(s);
		System.out.println(from+"BREAKING_WHITESPACE");
		from=CharMatcher.WHITESPACE.removeFrom(s);
		System.out.println(from+"whitespace");
		from=CharMatcher.ASCII.retainFrom(s);
		System.out.println(from+"ascii");
		from=CharMatcher.INVISIBLE.removeFrom(s);
		System.out.println(from+"invisible");
		from=CharMatcher.JAVA_LETTER.retainFrom(s);
		System.out.println(from+"letter");
		from=CharMatcher.JAVA_LOWER_CASE.retainFrom(s);
		System.out.println(from+"lower-case");
		from=CharMatcher.JAVA_UPPER_CASE.retainFrom(s);
		System.out.println(from+"upper-case");
		from=CharMatcher.javaLetter().replaceFrom(s, "$");
		System.out.println(from+"replaceFrom()");
		from=CharMatcher.JAVA_ISO_CONTROL.retainFrom(s);
		System.out.println(from+"iso-control");
		 from=CharMatcher.ASCII.trimFrom(s);
		System.out.println(from+"trim");
		String form=CharMatcher.javaDigit().or(CharMatcher.anyOf("sa")).retainFrom(s);
		System.out.println(form+"---");
		
		boolean matchesAnyOf = CharMatcher.anyOf(s).matchesAnyOf("sa");
		System.out.println(matchesAnyOf);
		String from2 = CharMatcher.is('s').retainFrom(s);
		System.out.println(from2);
		byte[] bytes = "a5程。/d".getBytes(Charsets.UTF_8);
		for(byte bt:bytes)
		System.out.println( (char)bt+"");
		
		
	}

}
