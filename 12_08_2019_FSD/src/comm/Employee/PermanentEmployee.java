package comm.Employee;

public class PermanentEmployee extends Employee {
private  int salary;
public PermanentEmployee() {
	super();
	
}
public PermanentEmployee(int salary) {
	super();
	this.salary=salary;
}
@Override
  protected] String getDetails() {
	
	return super.getDetails()+"salary:" + salary ;
	
}
}
