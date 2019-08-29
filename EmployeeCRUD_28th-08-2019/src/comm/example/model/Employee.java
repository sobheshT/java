package comm.example.model;

import javax.servlet.http.HttpServlet;

public class Employee  extends HttpServlet  {
	public static long serialVersionUID = 1L;
	private String name;
	private String password,email;
	private String country;
	public Employee() {
		super();
	}
	public Employee(String name, String password, String email,String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country=country;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", email=" + email + ", country=" + country + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}

