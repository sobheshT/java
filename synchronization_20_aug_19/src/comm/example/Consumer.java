package comm.example;
import java.util.Vector;
public class Consumer implements Runnable{
 private final Vector<Integer> sharedQueue;
 private final int SIZE;
 
	public Consumer(Vector<Integer> sharedQueue, int sIZE) {
	super();
	this.sharedQueue = sharedQueue;
	SIZE = sIZE;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				for(int i=0;i<7;i++) {
					System.out.println("Consumed:"+consume());
				}
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	private synchronized int consume() throws InterruptedException {
        //wait if queue is empty
        if(sharedQueue.isEmpty()) {
          
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                wait();
            }
        

        
            notifyAll();
            return (Integer) sharedQueue.remove(0);
       
    }

}
