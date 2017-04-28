package Threads11.DeadLock;

public class App {

	public static void main(String[] args) throws InterruptedException {
		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.firstThread(Thread.currentThread());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},"First Thread");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.secondThread(Thread.currentThread());;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},"Second Thread");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		runner.fishished();
	}

}
