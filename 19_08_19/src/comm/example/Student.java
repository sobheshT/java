package comm.example;

public class Student implements Comparable<Object> {
private String firstName;
private String lastName;
private int GPA;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String firstName, String lastName, int gPA) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	GPA = gPA;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) 
{
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getGPA() {
	return GPA;
}
public void setGPA(int gPA) {
	GPA = gPA;
}
@Override
public String toString() {
	return "Student [firstName=" + firstName + ", lastName=" + lastName + ", GPA=" + GPA + "]";
}

}
