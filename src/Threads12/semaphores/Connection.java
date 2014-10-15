package Threads12.semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection INSTANCE = new Connection();

	private int connections = 0;

	private Semaphore sem = new Semaphore(10,true);

	private Connection() {

	}

	public static Connection getInstance() {
		return INSTANCE;
	}
	public void connect(){
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			doConnect();
		}finally{
			sem.release();
		}
	}
	private void doConnect() {
	
		synchronized (this) {
			connections++;
			System.out.println("Conection " + connections);
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}
		
	}
}
