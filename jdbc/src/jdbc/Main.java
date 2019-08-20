package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
public class Main {
	private static Properties properties = null;
	private static Scanner scanner=new Scanner(System.in);
	static {
		properties = new Properties();
		properties.put("JDBC_URL", "jdbc:mysql://localhost:3306/employee");
		properties.put("USER", "root");
		properties.put("PASSWORD", "root");
	}

	public Main() {
		super();

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		MySqlconnectionFactory factory=MySqlconnectionFactory.createConnection();
		Connection connection=factory.getConnection();
		PreparedStatement pst=connection.prepareStatement("insert into emp values(?,?)");
		PreparedStatement dlt=connection.prepareStatement("DELETE from emp where name='sobhesh'");
		PreparedStatement upd=connection.prepareStatement("UPDATE emp SET name ='subham' where id=2");
		//System.out.print("ID: ");
		//int id=scanner.nextInt();
		//System.out.print("NAME: ");
		//String name=scanner.next();
		
		//pst.setInt(1, id);
		//pst.setString(2, name);
	    
		int count=upd.executeUpdate();
		count=dlt.executeUpdate();
		System.out.println(count+" row(s) updated");
		
	}
}
