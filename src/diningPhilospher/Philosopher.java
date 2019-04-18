package diningPhilospher;

public class Philosopher implements Runnable {

	Object leftFork;
	Object rightFork;
	
	 public Philosopher(Object leftFork, Object rightFork) {
	        this.leftFork = leftFork;
	        this.rightFork = rightFork;
	    }
	
	@Override
	public void run() {

			try{
				
				while(true)
				{
					// thinking
	                doAction(System.nanoTime() + ": Thinking");
				
	                synchronized (leftFork) {
	                    doAction(
	                      System.nanoTime() 
	                        + ": Picked up left fork");
	                    
	                    synchronized (rightFork) {
	                        // eating
	                        doAction(
	                          System.nanoTime() 
	                            + ": Picked up right fork - eating"); 
	                         
	                        doAction(
	                          System.nanoTime() 
	                            + ": Put down right fork");
	                    }
	                 // Back to thinking
	                    doAction(
	                      System.nanoTime() 
	                        + ": Put down left fork. Back to thinking");
				}
			}
		
	}catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
    }}
	
	private void doAction(String action) throws InterruptedException {
        System.out.println(
          Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
	
	

}
