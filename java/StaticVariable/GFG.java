// Java Program to show the Advantages of Static Variable

// Class 1
class emp {

	// Attributes of employees
	int id;
	String name;
	int salary;
	// Here we are declaring CEO as a static variable
	static String ceo;

	// Constructors of this class
	emp(int id, String name, int salary, String ceo)
	{
		// This keyword refers to current instance itself
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.ceo = ceo;
	}

	// Method of this class
	void display()
	{
		// Print all associated attributes
		System.out.println("ID: " + id + ", "
						+ "Name:: " + name + ", "
						+ "Salary: $" + salary + " & "
						+ "CEO:: " + ceo);
	}
}

// Class 2
// Main class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of class 1
		// Object 1
		emp Monodwip
			= new emp(1, "Monodwip", 30000, "Rinkel");

		// Object 2
		emp Mukta = new emp(2, "Mukta", 50000, "Rinkel");

		// We have changed the CEO for Subham, As CEO is
		// declared static, sowill change for all the
		// objects

		// Object 3
		emp Subham = new emp(3, "Subham", 40000, "Arnab");

		// Calling display() method over all objects
		Monodwip.display();
		Mukta.display();
		Subham.display();
	}
}
