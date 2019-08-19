package comm.stack;

public class MyStack {
String arr[];
private int index=0;
private int size;

public MyStack(int size) {
	this.size=size;
	arr=new String[size];
	
}


public String push(String element) {
	arr[index]=element;
	index++;
	return element;
}
public String pop(String element) {
	
	return arr[--index];
}

public int size() {
	return index;
}



}
