package test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cgl   -   2016年12月11日下午9:19:16  
 *  
 * @description:appendReplancement appendTail methods test:
 *
 */
public class MatcherTest {
	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("\\w+");
		
		Matcher matcher = pattern.matcher("i am cheng gl .");
		
		StringBuffer sb=new StringBuffer();
		while(matcher.find()){
			System.out.print(matcher.group()+":");
			  matcher.appendReplacement(sb, matcher.group().toUpperCase());
		}
		matcher.appendTail(sb);
		System.out.println();
		System.out.println(sb.toString());
		
	}

}
