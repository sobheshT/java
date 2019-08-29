package comm.example;

public class Calculator {
private int x;
private int y;
private int result;
public Calculator(int x, int y) {
	super();
	this.x = x;
	this.y = y;
}
public Calculator() {
	super();
	// TODO Auto-generated constructor stub
}
public int addMethod() {
	
	result=x+y;
	return result;
}
public int isGreater() {
	if(x>y) {
		return 1;
	}
	else
		return -1;
}
}
