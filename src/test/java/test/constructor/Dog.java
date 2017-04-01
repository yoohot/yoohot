package test.constructor;

public class Dog extends Animal {
	private String name;

	public Dog() {
		System.out.println("dog init");
		name = "jack";
	}

	public void say() {
		super.say();
		System.out.println("my name is:" + name);
	}

	public static void main(String[] args) {
		new Dog();
	}
}

class Animal {
	public Animal() {
		System.out.println("animal init");
		say();
	}

	// private
	public void say() {
		System.out.println("i am an animal..");
	}
}
