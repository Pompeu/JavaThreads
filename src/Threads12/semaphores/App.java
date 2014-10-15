package Threads12.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class App {

	public static void main(String[] args)throws Exception {
		
		
		
		ExecutorService exService = Executors.newCachedThreadPool();
		
		for(int i = 0 ;  i < 200 ; i ++){
			exService.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();				
				}
			});
		}
		exService.shutdown();
		
		exService.awaitTermination(1, TimeUnit.DAYS);
	}

}
