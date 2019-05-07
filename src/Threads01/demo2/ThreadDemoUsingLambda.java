package Threads01.demo2;

public class ThreadDemoUsingLambda {

	public static void main(String[] args){
		new ThreadDemoUsingLambda("first", 10);
		new ThreadDemoUsingLambda("second", 10);
	}
	
	
	private int count;
	private Thread t;
 
	
	
	public ThreadDemoUsingLambda(final String message, int n)
	{
		count=n;
		t= new Thread(()->{
			while(count -- > 0){
				System.out.println(message);
			}
		
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){
			return;
		}
		System.out.println(message + " thread all done.");
		
	});
		
		t.setName(message + " runner Thread");
        t.start();
}
}
