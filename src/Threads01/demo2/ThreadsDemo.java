package Threads01.demo2;

public class ThreadsDemo extends Thread{
	
	private String message;
	private int count;
	
	public void run() {
        while (count-- > 0) {
            System.out.println(message);
            try {
                Thread.sleep(100);    // in mSec
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(message + " all done.");
	}

	public ThreadsDemo(final String message, int n) {
        this.message = message;
        count = n;
        setName(message + " runner Thread");
    }
	
	public static void main(String[] argv) {
        new ThreadsDemo("Hello from X", 10).start();
        new ThreadsDemo("Hello from Y", 15).start();
    }
}
