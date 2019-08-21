package comm.tasks;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Employee implements Comparable<Employee> {
	Set<Employee> emp=new TreeSet<Employee>();
private int id;
private String name;
private String department;
private String dateOfjoining;
private int age;
private int salary;

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int id, String name, String department, String dateOfjoining, int age, int salary) {
	super();
	this.id = id;
	this.name = name;
	this.department = department;
	this.dateOfjoining = dateOfjoining;
	this.age = age;
	this.salary = salary;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getDateOfjoining() {
	return dateOfjoining;
}
public void setDateOfjoining(String dateOfjoining) {
	this.dateOfjoining = dateOfjoining;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
@Override
public String toString() {
	//System.out.printf("%-15s, %-30s,%-30s,%-10s %-10s\n",name,department,dateOfjoining,age,salary);
	return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", dateOfjoining=" + dateOfjoining
			+ ", age=" + age + ", salary=" + salary + "]\n";
}
@Override
public int compareTo(Employee e)
{
	 if(this.salary==e.salary)  
	      return 0;  
	   else if(this.salary>e.salary)  
	      return 1;  
	   else  
	      return -1;  
}
public void addEmployee(int id,String name,String department, String dateOfjoining, int age, int salary) {
	Scanner scan=new Scanner(System.in);
	
		name=scan.next();
		department=scan.next();
		dateOfjoining=scan.next();
		age=scan.nextInt();
		salary=scan.nextInt();
		emp.add(new Employee(id,name,department,dateOfjoining,age,salary));
	
	
}
public void viewDetail() {
	System.out.println(emp.toString());
}
}
