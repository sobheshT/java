package comm.fileToDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.SQLException;

import comm.example.model.Employee;
import comm.example.service.EmployeeServiceImpl;

public class AddEmployee {
private BufferedReader reader;
private Buffer writer;
static String[] str =new String[4];
public void AddEmployee(String source ) throws IOException {
	try {
		EmployeeServiceImpl s1=new EmployeeServiceImpl();
		reader=new BufferedReader(new FileReader(source));
		String line=reader.readLine();
		while(line!=null) {
			str=line.split("\\s");
			System.out.println(str[0]+" "+str[1]+" "+str[2]+""+str[3]);
			s1.createemployee(new Employee(Integer.parseInt(str[0]),str[1],str[2],str[3]));
			line=reader.readLine();
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
