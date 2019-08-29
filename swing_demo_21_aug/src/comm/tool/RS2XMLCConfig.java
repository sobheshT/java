package comm.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import comm.example.factory.MyConnectionFactory;

public class RS2XMLCConfig {
private MyConnectionFactory factory;
private Connection connection;
public RS2XMLCConfig() throws SQLException {
	factory=MyConnectionFactory.createObject();
	connection=factory.getConnection();
	// TODO Auto-generated constructor stub
}
public ResultSet getAllEmployee() throws SQLException {
	Statement st=connection.createStatement();
	ResultSet rs=st.executeQuery("select * from emp1");
	return rs;
	
}

}
