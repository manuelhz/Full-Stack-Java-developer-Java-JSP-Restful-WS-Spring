package test_pack;
public class Child extends Parent {
	int age = 0;
	
	public Child(String name, int age) {
		super(name);
		this.age = age;
	}
	public void showAge() {
		System.out.println("age: " + this.age);
	}
}
