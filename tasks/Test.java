package comm.tasks;

import java.util.Scanner;

public class Test {
	static Employee e=new Employee();
	static Scanner scan=new Scanner(System.in);
public static void main(String[] args) {
	
	String name=null;
	String department=null;
	String dateOfjoining = null;
	int age=0;
	int salary=0;
	int option;
	System.out.println("Enter number of Employee Detail you want to enter");
	option=scan.nextInt();
	for(int i=1;i<=option;i++) {
		System.out.println("Enter Details for Employee "+i);
		e.addEmployee(i, name, department, dateOfjoining, age, salary);
	}
	e.viewDetail();
}
}

