package cn.yoohot.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	
	public static void main(String[] args) {
		
		/**
		 * 从applicationContext中获取到的是aop对象，用他调用则会启用aop，对象本身方法中调用其他的方法不会启用aop
		 */
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContextTest.xml");
		 
		 AddressAop addressAop=ctx.getBean(AddressAop.class);
		 
		 System.out.println("1"+addressAop);
		 Address address=ctx.getBean(Address.class);
		 
		 System.out.println("2"+address);
		 address.sysHCd();
		 
		 Person person=ctx.getBean(Person.class);
		 
		 System.out.println(person);
		 
		 Car car=ctx.getBean(Car.class);
		 
		 System.out.println(car);
		 
		
	}

}
