package comm.staticexample;

public class Account {
private static int count= 0;
public Account() {
super();
count++;
System.out.println("No. of Account:"+count);
}
}
