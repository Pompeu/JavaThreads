package Threads08WaitAndNotify;

import java.util.Scanner;

public class Processor {

	static int[] a=new int[10];
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread ruuning ...");
			System.out.println("Going to wait for consumer instructions");
			wait();
			System.out.println("Resumed.");

		}
	}

	public void consume() throws InterruptedException {
		Thread.sleep(500);
		
		synchronized (this) {
			System.out.println("Wating for return key.");
			new Scanner(System.in).nextLine();
			System.out.println("Return key pressed.");
			System.out.println("Notifying to producer to resume");
			notify();
			Thread.sleep(2000);
		}
		
		
		
	}
	
	public void fillArray() throws InterruptedException 
	{
	
		wait();
		
	}
}
