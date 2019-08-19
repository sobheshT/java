package comm.Employee;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	public Employee(){
		super();
	}
	public Employee(int id,String firstName,String lastName){
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	protected String getDetails(int id,String firstName,String lastName) {
		
		
		return id+"-"+firstName+"-"+lastName;
	}

}
