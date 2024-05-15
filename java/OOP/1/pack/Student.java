import java.util.Scanner;
public class Student {
  Scanner scan = new Scanner(System.in);
  String name = "";
  int marks = 0;
  
  public void getDetails(){
    System.out.println("Enter your Name: ");
    name = scan.nextLine();
    System.out.println("Enter your marks: ");
    marks = scan.nextInt();
  }
  public void showDetails(){
    System.out.println("Name of student is:  "+name);
    System.out.println("Marks of student are "+marks);

  }
}
