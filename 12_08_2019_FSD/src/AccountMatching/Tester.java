package AccountMatching;

public class Tester {
	public static void main(String[] args) {
		Account Account1=null;
	    Account1= new Account();
	    Account Account2=null;
	    Account2= new Account();
	    Account1.setAccountNumber(1);
	    Account1.setAccountHolder("Sobhesh");
	  
	    Account2.setAccountHolder("Sobhesh");

	    if(Account1.equals(Account2)) {
	    	System.out.println("Matched");
	    }
	    else {
	    	System.out.println("Not Matched");
	    }
	    
	}
}
