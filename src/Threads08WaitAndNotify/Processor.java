package Threads08WaitAndNotify;

import java.util.Scanner;

public class Processor {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread ruuning ...");
			wait();
			System.out.println("Resumid.");

		}
	}

	public void consume() throws InterruptedException {
		Thread.sleep(500);

		synchronized (this) {
			System.out.println("Wating for return key.");
			new Scanner(System.in).nextLine();
			System.out.println("Return key pressed.");
			notify();
			Thread.sleep(2000);
		}
	}
}
