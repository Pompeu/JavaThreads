package Threads01.demo1;

class Runner extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Looping !!!!"+ this.getName() +" with value "+ i);
			try {
				if(i%2==0)
				{
				System.out.println("sleeping "+this.getName());
				Thread.sleep(100*2);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class App {

	public static void main(String[] args) {

		Runner runner1 = new Runner();
		runner1.setName("first thread");
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.setName("second thread");
		runner2.start();
		
	}

}
