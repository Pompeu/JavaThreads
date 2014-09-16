package Threads09LowLevelSynchronization;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;

		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
			
		}
	}

	public void consume() throws InterruptedException {
		Random randon = new Random();
		while (true) {
			synchronized (lock) {
				
				while(list.size() == 0){
					lock.wait();
				}
				System.out.printf("List Size is : " + list.size());
				int value = list.removeFirst();
				System.out.println(" value is: " + value);
				lock.notify();
			}
			Thread.sleep(randon.nextInt(1000));
		}
	}
}
