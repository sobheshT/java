package comm.example.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comm.example.factory.*;
import comm.example.model.Employee;
public class EmployeeDaoImpl implements EmployeeDao{
private MyConnectionFactory factory=null;
private Connection connection=null;
private PreparedStatement pStatement=null;
private Statement statement=null;
private ResultSet resultSet=null;

public EmployeeDaoImpl() throws SQLException{
	super();
	factory=MyConnectionFactory.createObject();
	connection=factory.getConnection();
}
@Override
public void createEmployee(Employee employee) {
	try {
		pStatement=connection.prepareStatement("insert into emp1 values(?,?,?,?)");
		pStatement.setInt(1,employee.getId());
		pStatement.setString(2, employee.getFirstname());
		pStatement.setString(3, employee.getLastname());
		pStatement.setString(4, employee.getEmail());
		pStatement.executeUpdate();
		
	}
	catch(SQLException e) {
		System.out.println("Duplicate id");
		e.printStackTrace();
	}
	finally {
		
	}
	// TODO Auto-generated method stub
	
}
@Override
public List<Employee> getAllEmployees() {
	// TODO Auto-generated method stub
	List<Employee> list=new ArrayList<Employee>();
	try {
		statement=connection.createStatement();
		resultSet=statement.executeQuery("select * from emp1");
		while(resultSet.next()) {
			list.add(new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4)));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}
@Override
public Employee getEmployeeById(int id) {
	// TODO Auto-generated method stub
	return null;
}


}
