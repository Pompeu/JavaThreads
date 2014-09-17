package Threads10ReentrantLocks;


public class App {

	public static void main(String[] args) throws InterruptedException {
		final Runner runner = new Runner();
		
		Thread t1 = new Thread(()-> {	
			try {
				runner.firstThreada();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Thread t2 = new Thread(()-> {	
			try {
				runner.secondThreads();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		runner.finished();
	}
}
