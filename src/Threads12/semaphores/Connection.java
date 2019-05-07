package Threads12.semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
	//only one instance throughout all objects
	private static Connection INSTANCE=null;
	private static int connections;

	//Semaphore(MAX_AVAILABLE, true);
	// MAX_AVAILABLE is a parameter which says how many availables
	private static Semaphore sem; 
 
	//constructor
	private Connection() {
		sem = new Semaphore(10,true);
		connections = 0;
	}

	//if instance is not present new instance will be initialized else 
	// already existing instance will be returned
	public static Connection getInstance() {
		
		if(INSTANCE==null)
		{
			INSTANCE = new Connection();
		}
		
		
		return INSTANCE;
	}
	
	
	//method to connects
	public void connect(Thread thread){
		synchronized(this)
		{
		System.out.println(" ");
		System.out.println(thread.getName()+"connecting ...");
		System.out.println("available permits for "+ thread.getName()+" "+sem.availablePermits());
		System.out.println("existing Connections before " +thread.getName()+" entered "+ connections);
		System.out.println(" ");
		
		try {
			//Acquires a permit from this semaphore, 
			//blocking until one is available, or the thread is interrupted.
			System.out.println(thread.getName()+" aquaring semaphore");
			sem.acquire();
			System.out.println("available permits left after acquire from"+thread.getName()+" "+sem.availablePermits());
			increaseNumberOfConnection(thread);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(" ");
		}

		if(sem.availablePermits()<5 || connections>7){
			
			System.out.println("connections are greater than 7 or semaphore is less than 5 release some semaphores");
			//releasing semaphore
			System.out.println(thread.getName()+" releaseing semaphore");
			sem.release();
			System.out.println("available permits left after release from"+thread.getName()+" "+sem.availablePermits());
			decreaseNumberOfConnection(thread);
		}
		System.out.println(" ");
	}
	
	private void increaseNumberOfConnection(Thread thread) {
		System.out.println(" ");
	//synchronized is used such only one thread can enter at one time
		synchronized (this) {
			//increasing number of connections
			System.out.println(thread.getName()+" increasing connection");
			connections++;
			System.out.println("No of Conections after increase" + connections);
		}
		
	}
	
	
	private void decreaseNumberOfConnection(Thread thread) {
		System.out.println(" ");
		//synchronized is used such only one thread can enter at one time
		synchronized (this) {
			//decreasing number of connections
			System.out.println(thread.getName()+" decreasing connection");
			connections--;
			System.out.println("No of Conections after decrease" + connections);
		}
			
		}
		
		
	}

