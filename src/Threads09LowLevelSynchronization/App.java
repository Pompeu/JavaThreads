package Threads09LowLevelSynchronization;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	public static void main(String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		
		Thread t1 = new Thread(()-> {	
			try {
				processor.produce();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		Thread t2 = new Thread(()-> {	
			try {
				processor.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		t1.start();
		t2.start();
	}
}
