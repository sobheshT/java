package comm.singeltonpattern;

public class Tester {
public static void main(String[] args) {
	Messaging m = Messaging.createMessagingObject("tom");
	System.out.println(m);
	Messaging m1=Messaging.createMessagingObject("Harry");
	System.out.println(m.equals(m1));
	
	
}
}
