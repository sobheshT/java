package comm.singeltonpattern;

public class Messaging {
private String message;
private static Messaging messaging;
private Messaging() {
	
}
private Messaging(String message) {
	this.message=message;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return  message;
}
public static Messaging createMessagingObject(String name) {
	if (messaging==null) {
		messaging=new Messaging(name);
	}
	return messaging;
}

}
