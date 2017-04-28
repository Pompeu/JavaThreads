package Threads01.demo2;

class Runner implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Looping !!!!"+  Thread.currentThread().getName() +" with value "+ i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class App {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner(),"first thread");
		Thread t2 = new Thread(new Runner(),"second thread");
		Thread t3 = new Thread(new Runner(),"third thread");
		Thread t4 = new Thread(new Runner(),"fourth thread");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
