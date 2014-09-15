package Threds04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random randon = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(randon.nextInt(100));
		}

	}

	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(randon.nextInt(100));
		}
		
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();

		}
	}

	public void main() {
		System.out.println("Starting ...");

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time take: " + (end - start));

		System.out.println("List: " + list1.size() + " : " + list2.size());

	}

}
