package test.innerCls;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author cgl   -   2016年11月10日下午3:03:58  
 *  
 * @description:内部类使用外部方法的参数，若修改其指向另外的对象，则会报错，需要是final；<br>
 *                 因为内部类中参数实质上是对象同步，引用不同步；在内部类调用的引用并非是外部方法形参传过来的，其实是两个不同的引用（在编译器确定的），<br>
 *                 java为了确保对象属性同步，所以不允许内部类修改其为其他的引用(试想若修改内部类的引用为新的对象，外部引用并没有同步的指定到最新的对象)。所以形参必须是final<br>
 *
 */
public class Cycle {

	public class InnerClass implements Tool {

		@Override
		public void run() {
			System.out.println("inner class run tools.");
			Cycle.this.say(null);
		}
	}

	public void say( List<String> text) {
		new Tool() {
			{
               text.add("a");
               text.add("b");
               text.add("c");
			}
			@Override
			@SuppressWarnings({"test final"})
			public void run() {
				//ERROR:test=new ArrayList<>();
                 System.out.println("text val="+text);
			}
		}.run();;
	}

	public InnerClass getInner() {
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		Cycle cycle=new Cycle();
		cycle.say(new ArrayList<>());
		Cycle.InnerClass tool=cycle.getInner();
		tool.run();
		Tool tools = cycle.new InnerClass();
		
	}

}
