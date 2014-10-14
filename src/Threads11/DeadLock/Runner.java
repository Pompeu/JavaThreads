package Threads11.DeadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Account acc1 = new Account();
	private Account acc2 = new Account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquiereLock(Lock fistLock, Lock seconlock)
			throws InterruptedException {
		boolean gotFirstLock = false;
		boolean gotSecondLock = false;
		while (true) {
			try {
				gotFirstLock = fistLock.tryLock();
				gotSecondLock = seconlock.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					return;
				}
				if (gotFirstLock) {
					fistLock.unlock();
				}
				if (gotSecondLock) {
					seconlock.unlock();
				}
			}
			Thread.sleep(1);

		}
	}

	public void firstThread() throws InterruptedException {
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {

			acquiereLock(lock1, lock2);

			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			acquiereLock(lock2, lock1);

			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void fishished() {
		System.out.println("Acc 1 balance " + acc1.getBalance());
		System.out.println("Acc 2 balance " + acc2.getBalance());
		System.out.println("Total balance "
				+ (acc1.getBalance() + acc2.getBalance()));
	}
}
