package Threads11.DeadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Account acc1 = new Account();
	private Account acc2 = new Account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquiereLock(Lock fistLock, Lock seconlock,Thread thread)
			throws InterruptedException {
		boolean gotFirstLock = false;
		boolean gotSecondLock = false;
		while (true) {
			try {
				gotFirstLock = fistLock.tryLock();
				gotSecondLock = seconlock.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					System.out.println("both locks true for "+thread.getName());
					return;
				}
				if (gotFirstLock) {
					System.out.println("only first lock true for "+thread.getName()+" releasing lock");
					fistLock.unlock();
				}
				if (gotSecondLock) {
					System.out.println("only second lock true for "+thread.getName()+" releasing lock");
					seconlock.unlock();
				}
			}
			Thread.sleep(1);

		}
	}

	public void firstThread(Thread thread) throws InterruptedException {
		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			System.out.println(thread.getName()+"acquiring locks");
			acquiereLock(lock1, lock2,thread);

			try {
				System.out.println(thread.getName()+" transfering amount");
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				System.out.println(thread.getName()+" releasing both locks");
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread(Thread thread) throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(thread.getName()+" acquiring locks");
			acquiereLock(lock2, lock1,thread);

			try {
				System.out.println(thread.getName()+" transfering amount");
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				System.out.println(thread.getName()+" releasing both locks");
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
