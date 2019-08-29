package comm.example.threadDemo;

public class ThreadDemo2 implements Runnable{

	public ThreadDemo2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for(int j=0;j<15;j++) {
			if(j==10) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("::"+j);
		}
		
	}

}
