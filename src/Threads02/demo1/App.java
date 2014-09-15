package Threads02.demo1;

import java.util.Scanner;

class Processor extends Thread {
	
	
	
	private volatile boolean running = true;

	@Override
	public void run() {

		while (running) {
			System.out.println("Hello!!!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {

	private static Scanner scanner;

	public static void main(String[] args) {

		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Click on BackSpace ");
		scanner = new Scanner(System.in);
		scanner.nextLine();
		proc1.shutdown();
	}

}
