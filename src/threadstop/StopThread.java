package threadstop;

public class StopThread  extends Thread{

	protected volatile boolean done = false;
	
	 public void run() {
	        while (!done) {
	            System.out.println("thread is running");
	            try {
	                sleep(720);
	            } catch (InterruptedException ex) {
	                // nothing to do
	            }
	        }
	        System.out.println("thread finished.");
	    }
	 
	 public void shutDown() {
	        done = true;
	    }

	 public static void main(String[] args) throws InterruptedException
	 {
		 StopThread t1=new StopThread();
		 t1.setName("my thread");
		 t1.start();
		 Thread.sleep(1000*5);
		 t1.shutDown();
	 }
}

