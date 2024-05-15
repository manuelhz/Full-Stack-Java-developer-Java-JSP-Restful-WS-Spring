package test_pack;
import java.util.Scanner;

public class TestProject {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Name? ");
		String myName = scan.next();
		
		System.out.println("Age? ");
		int myAge = scan.nextInt();
		
		System.out.println("Gender? ");
		String myGender = scan.next();
		
		GrandChild obj = new GrandChild(myName, myAge, myGender);
		obj.showAge();
		obj.showGender();
		obj.showName();
				

	}

	
}
