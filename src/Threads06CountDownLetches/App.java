package Threads06CountDownLetches;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	private CountDownLatch latch;
	private String name;

	public Processor(CountDownLatch latch,String name) {
		this.latch = latch;
		this.name=name;
	}

	@Override
	public void run() {
		System.out.println("Started ."+name+" "+Date.from(Instant.now()).toString());
	//	System.out.println("latch countdown of "+name+" ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//used to reduce countdown of latch by one
		latch.countDown();
	}

}

public class App {

	public static void main(String[] args) throws InterruptedException {
		//used to initialize countdown latch
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executos = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			executos.submit(new Processor(latch,"A "+i));
		}
		
		
		System.out.println("waiting for thread to complete");
		//used main thread to wait for number of countdown latch
		latch.await();
		System.out.println("Completed all count down threads starting for rest");
		
	}

}
