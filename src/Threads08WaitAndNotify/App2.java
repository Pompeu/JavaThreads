package Threads08WaitAndNotify;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App2 {
	//A queue that takes things from Thread and provide the same to other threads
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	static int a[]={10,20,30,40,70,80,90,100,50};

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer(Thread.currentThread());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},"thread 1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				boolean test=true;
				try {
					while(test)
					{
					if(queue.size()>1)
					{
						System.out.println("elements is queue"+queue.size());
					consumer(Thread.currentThread());
					test=false;
					}
					else{
						System.out.println("no items in queue sleeping "+Thread.currentThread().getName());
						Thread.sleep(1000);
					}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		},"thread 2");
		
		
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		
		
	}

	//inserting records to the queue
	private static void producer(Thread thread) throws InterruptedException {
		System.out.println("Producer thread is="+thread.getName());
		for(int i=0;i<=5;i++)
		{
			System.out.println("putting in queue "+ a[i]);
			queue.put(a[i]);
	
		}
		System.out.println("existing from producer function");
	}
	
	
	//getting records from the queue until it is not empty
	private static void consumer(Thread thread) throws InterruptedException {
		System.out.println("Consumer thread is="+thread.getName());
		while(!queue.isEmpty()){
				Integer value = queue.take();
				System.out.println("Value is : "+ value + " "
						+ "Queue size is" + queue.size());
			}
		}
	}

