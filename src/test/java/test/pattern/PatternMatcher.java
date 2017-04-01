package test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	private static String source="asd asd     cd sd cheng sda ";
	
	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("(\\w+)\\s+(\\w+)");
		Matcher matcher = pattern.matcher(source);
		while(matcher.find()){
			for(int i=0;i<=matcher.groupCount();i++){
				System.out.print("start index:"+matcher.start(i));
				System.out.print(matcher.group(i));
				System.out.print("end index:"+matcher.end(i));
				System.out.println();
			}
			System.out.println("---------------------------------------------------------"+(2|6));
		}
		
		
	}

}
