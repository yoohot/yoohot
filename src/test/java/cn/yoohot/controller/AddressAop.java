package cn.yoohot.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AddressAop {

	@Pointcut("execution(* Address.*())")
	public void pointCut(){}
	
	@Before(value="pointCut()")
	public void before(){
		System.out.println("before method start . aop i..");
	}
	
	
}
