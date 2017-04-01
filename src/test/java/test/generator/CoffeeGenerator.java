package test.generator;

import java.util.Iterator;
import java.util.Random;

interface Generator<T>{
	T next();
}

interface Coffee{}

class BradCoffee implements Coffee{}
class WhiteCoffee implements Coffee{}
class SweetCoffee implements Coffee{}
class HotCoffee implements Coffee{}
class IceCoffee implements Coffee{}


public class CoffeeGenerator<T> implements Iterable<Coffee>,Generator<Coffee> {
	
	private Random random=new Random(47);
	
	private int size=0;
	
	
	
	
	public CoffeeGenerator(int size) {
		super();
		this.size = size;
	}
	public CoffeeGenerator() {
	}

	private T objT;//泛型属性，要么是空，要么是调用者传递过来的实例，不能new，因为无法确定类型
	
	Class<Coffee> [] types=new Class[]{BradCoffee.class,WhiteCoffee.class,SweetCoffee.class,HotCoffee.class,IceCoffee.class};

	@Override
	public Coffee next() {
		try {
			return types[random.nextInt(types.length)].newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public T generator(){
		
		return objT;
	}
	

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	
	class CoffeeIterator implements Iterator<Coffee>{

		int count=size;
		@Override
		public boolean hasNext() {
			return count>0;
		}

		@Override
		public Coffee next() {
			if(count==0)
             throw  new NullPointerException("there is no more element");
				count--;
			return CoffeeGenerator.this.next();
		}
		
		
	}
	
	public static void main(String[] args) {
         CoffeeGenerator<String> generator=new CoffeeGenerator<>(5);
         
         for(int i=0;i<3;i++)System.out.println(generator.next());
         
         Iterator<Coffee> iterator = generator.iterator();
         
         while(iterator.hasNext()){
        	 System.out.println(iterator.next());
         }
         System.out.println("--------");
     /*    System.out.println( iterator.next());
        System.out.println( iterator.next());*/
        System.out.println("aa".hashCode());
         
	
	}
	
	

}
