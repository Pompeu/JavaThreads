package Threads12.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class App {

	public static void main(String[] args)throws Exception {
		
		
		
		ExecutorService exService = Executors.newCachedThreadPool();
		
		for(int i = 0 ;  i < 10; i ++){
			
			exService.submit(new Runnable() {
				
				@Override
				public void run() {
					//to get an instance of a connection and calling connect method
					Connection.getInstance().connect(Thread.currentThread());				
				}
			},"Thread No "+i);
			
		}
		
		//Initiates an orderly shutdown in which previously 
		//submitted tasks are executed, but no new tasks will be accepted.
		System.out.println("service is shutting down");
		exService.shutdown();
		
		//Blocks until all tasks have completed execution after a shutdown request
		// or the timeout occurs, or the current thread is interrupted, whichever happens first.
		System.out.println("service is waiting for termination");
		exService.awaitTermination(1, TimeUnit.DAYS);
	}

}
