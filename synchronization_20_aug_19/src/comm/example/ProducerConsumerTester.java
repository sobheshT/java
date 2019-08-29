package comm.example;

public class ProducerConsumerTester {
	private final MyStack myStack=new MyStack();

	public static void main(String[] args) {
		MyStack myStack=new MyStack();
		StackProducer p=new StackProducer(myStack);
Thread t1=new Thread(p);
t1.start();
StackConsumer c=new StackConsumer(myStack);
Thread t2=new Thread(c);
t2.start();
}

	
}
