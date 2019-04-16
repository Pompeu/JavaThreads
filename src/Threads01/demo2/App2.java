package Threads01.demo2;

public class App2  implements Runnable{

	@Override
	public void run() {
		
		System.out.println(" this is App2 run method");
	}
	
	public static void main(String[] args)
	{
		App2 thread=new App2();
		Thread t=new Thread(thread);
		t.start();
	}
	

}
