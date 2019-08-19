package comm.example;

public class AddArguments {
	public static void main(String[] args) {
		int sum=0;
		for(String a:args) {
			try {sum+=Integer.parseInt(a);}
			catch(NumberFormatException nfe){
				System.err.println(nfe.toString());
				nfe.printStackTrace();
				nfe.getCause();
				nfe.getMessage();
				System.exit(0);
			}
			
		}
		System.out.println("Sum: "+sum);
	}
	
}
