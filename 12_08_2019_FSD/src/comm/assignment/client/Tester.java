package comm.assignment.client;
import comm.assignment.MyDate;
public class Tester {
	
	public static void main(String[] args) {
		MyDate myDate=null;
		myDate=new MyDate();
		System.out.println(myDate.setDay(32));
		System.out.println(myDate.setMonth(30));
		System.out.println(myDate.setDay(myDate.getDay()+1));
			//new MyDtae().createDate(8,10,1997); -- orphan object
	}

}
