package Threads03Synchornized.demo1;

public class App {
	private int count = 0;
	private int i=0;

	public synchronized void increment() {
		count++;
	}
	
	public synchronized void loops(Thread thread) throws InterruptedException {
		
		for(;i<10;i++)
		{
			System.out.println(count + "index "+i+ thread.getName());
			
		}
	}


	public static void main(String[] args) {
		App app = new App();
		app.demork();
	}

	public void demork() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					increment();
				}
				try {
					loops(Thread.currentThread());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"first thread");
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					increment();
				}
				try {
					loops(Thread.currentThread());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},"second thread");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Count  is " + count);
	}
}
