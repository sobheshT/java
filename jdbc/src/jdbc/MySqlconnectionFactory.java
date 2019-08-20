package jdbc;
import java.sql.*;
public class MySqlconnectionFactory {
private static Connection connection=null;
private static MySqlconnectionFactory connectionFactory;
public MySqlconnectionFactory()throws SQLException
{
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
}
public static MySqlconnectionFactory createConnection() throws SQLException{
	if(connectionFactory==null)
	{
		connectionFactory=new MySqlconnectionFactory();
	}
	return connectionFactory;
}
public Connection getConnection() throws SQLException
{
	return connection;
}

}