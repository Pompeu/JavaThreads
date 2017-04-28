package Threads02.demo1;

import java.util.Scanner;

class Processor extends Thread {
	
	private volatile boolean running = true;
	int i=0;
	@Override
	public void run() {

		while (running) {
			System.out.println("Hello!!!"+Thread.currentThread().getName()+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			
			if(i>10)
			{
				shutdown();
			}
		}
	}

	public void shutdown() {
		System.out.println("shut down");
		running = false;
	}
	
	public void scan(Scanner scanner)
	{
		System.out.println("Click on BackSpace ");
		scanner = new Scanner(System.in);
		String word=scanner.nextLine();
		System.out.println("scanner"+word);
	}
}

public class App {

	private static Scanner scanner;

	public static void main(String[] args) {

		Processor proc1 = new Processor();
		proc1.setName("thread one");
		Processor proc2 = new Processor();
		proc2.setName("thread two");
		proc1.start();
	    proc2.start();
		proc2.scan(scanner);
		proc1.shutdown();
		proc2.shutdown();
	}

}
