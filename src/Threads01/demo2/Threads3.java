package Threads01.demo2;

public class Threads3 {

	public static void main(String[] args)
	{
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(" this is inner class thread");
			}
		});
		
		t.start();
	}
	
}
