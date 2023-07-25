public class Student 
{	
	//Data Members
	private String firstName;
	private String lastName;
	private String address;
	private String telephone;
	private String major;
	private String minor;
	private int credits;
	private double gpa;

	//No arg constructor
	public Student()
	{
		firstName = "John";
		lastName = "Smith";
		address = "123 Filbert St.";
		telephone = "(555) 123-4567";
		major = "Computer Science";
		minor = "None";
		credits = 80;
		gpa = 3.5;
	}
	
	//arg constructor
	public Student(String fn, String ln, String a, String t, String ma, String mi, int c, double g)
	{
		firstName = fn;
		lastName = ln;
		address = a;
		telephone = t;
		major = ma;
		minor = mi;
		credits = c;
		gpa = g;
	}
	
	//accessors
	public String getFirst() {return firstName;}
	public String getLast() {return lastName;}
	public String getAddress() {return address;}
	public String getTelephone() {return telephone;}
	public String getMajor() {return major;}
	public String getMinor() {return minor;}
	public int getCredits() {return credits;}
	public double getGPA() {return gpa;}

	//other methods
}