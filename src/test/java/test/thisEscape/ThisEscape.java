package test.thisEscape;

import java.lang.annotation.Annotation;

import org.springframework.context.event.EventListener;

/**
 * @author cgl   -   2016年12月13日下午4:23:10  
 *  
 * @description:内部类溢出，将隐含的溢出外部类。若从构造器中溢出，因为外部类还未构造完成，将导致不可预知错误!<br>
 * 不要在构造过程中使this引用溢出
 *
 */
public class ThisEscape {
	private String s="sdfg";
	public void say(){
		boolean equals = ThisEscape.this.s.equals("2");
	}
	
	public ThisEscape(){
		new EventListener() {
			
			@Override
			public Class<? extends Annotation> annotationType() {
 				boolean equals = ThisEscape.this.s.equals("sdrf");
				boolean equals2 = s.equals("");
				return null;
			}
			
			@Override
			public Class<?>[] value() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String condition() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Class<?>[] classes() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
