package Threads10ReentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private Scanner s;

	private void increment() {
		for (int i = 0; i < 100000; i++) {
			count++;
		}
	}

	public void firstThreada() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting ....");
		cond.await();
		System.out.println("Weken Up!");
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThreads() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press the return Key!");
		s = new Scanner(System.in);
		s.nextLine();
		System.out.println("Got return key!");
		cond.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}
