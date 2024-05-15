package test_pack;
public class GrandChild extends Child {
	String gender = "";
	
	public GrandChild(String name, int age, String gender) {
		super(name, age);
		this.gender = gender;
	}
	public void showGender() {
		System.out.println("Gender: " + this.gender);
	}

}
