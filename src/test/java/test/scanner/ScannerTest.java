package test.scanner;

import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		Scanner scanner1=new Scanner(" 12 3 a e 1\n2 2");
		
		//System.out.println(scanner1.nextInt());
		while(scanner1.hasNextInt()){//hasNextXX用来判断下一个输入分词是否是所需的类型
			System.out.println("next Int.:"+scanner1.next());
		}
		while(scanner1.hasNext() &&scanner1.hasNext()){
			System.out.println(scanner1.next());
		}
		scanner1=new Scanner("12 3 a e 1\n2 2");
		while(scanner1.hasNext()){
			System.out.println("next"+scanner1.next());
		}
		scanner1=new Scanner("12 3 a e 1\n2 2");
		while(scanner1.hasNextLine()){
			System.out.println("next line:"+scanner1.nextLine());
		}
		
		scanner1.close();
		
		
	}

}
