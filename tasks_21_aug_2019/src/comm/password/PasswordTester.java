package comm.password;



import java.util.Scanner;

public class PasswordTester {

	public static void main(String[] args) {
		UserMainCode w= new UserMainCode();
	Scanner sc = new Scanner(System.in);
	String password;
	boolean p;
	System.out.println("enter password");
	password=sc.next();
	
	p = UserMainCode.PasswordMatcher(password);
	
if(p==true
) {
	System.out.println("valid password");
}else{
	System.out.println("invalid password");
}
	}

}
