package comm.fileToDB;

import java.io.IOException;

public class MainEmployee {
public static void main(String[] args) {
	AddEmployee s1=new AddEmployee();
	try {
		s1.AddEmployee("Demo.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
