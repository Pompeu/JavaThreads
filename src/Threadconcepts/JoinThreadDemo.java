package Threadconcepts;

public class JoinThreadDemo extends Thread {
  
	public JoinThreadDemo(String name)
	{
		this.setName(name);
	}
	public void run()
	{

		System.out.println("Reading");
		try {
			//System.in.read();
			System.out.println("xyz");
		} catch (Exception ex) {
			System.err.println(ex);
		}
		System.out.println("Thread Finished.");
	}
	
	public static void main(String[] args)
	{
		JoinThreadDemo j1=new JoinThreadDemo("one");
		JoinThreadDemo j2=new JoinThreadDemo("two");
		System.out.println("Starting");
		j1.start();
		j2.start();
		System.out.println("Joining");
		try{
			j1.join();
			}catch(InterruptedException ex)
		{
			// should not happen:
			System.out.println("no interrupt to sleep");
		} 
		System.out.println("Main Finished.");
	}
	
}
