package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Properties;
public class JdbcDemo1 {
    private static Properties properties=null;
   
    static {
    	properties=new Properties();
        properties.put("JDBC_URL","jdbc:mysql://localhost:3360/employee");
        properties.put("USER","root");
        properties.put("PASSWORD","root");
    }
    
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		//register the driver
// DriverManager.deregisterDriver(new org.h2.Driver());
	//	DriverManager.registerDriver(new com.mysql.cj.jdbc);
	
	//Class.forName("Org.h2.Driver");
	
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	Statement statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select *from emp");
	System.out.println("ID NAME ");
	while(resultSet.next())
	{
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
	}
	
	}
	
	
}
