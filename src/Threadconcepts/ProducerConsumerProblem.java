package Threadconcepts;

import java.io.IOException;
import java.util.LinkedList;

public class ProducerConsumerProblem {

	protected LinkedList<Object> list = new LinkedList<>();
	
	protected void produce()
	{
		int len=0;
		
		synchronized(list){
			Object current=new Object();
			list.add(current);
			len=list.size();
			list.notifyAll();
		}
		
		System.out.println(" list size now "+list.size());
	}
	
	protected void consume()
	{
		Object obj=null;
		int len=0;
		synchronized (list) {
			while(list.size()==0)
			{
				try{
					list.wait();
				}catch(InterruptedException ex){
					return;
				}
			}
			
			obj=list.removeLast();
			len=list.size();
			
		}
		System.out.println("Consuming object " + obj);
        System.out.println("List size now " + len);
	}
	
	public static void main(String[] args) throws IOException
	{
		ProducerConsumerProblem p1=new ProducerConsumerProblem();
		System.out.println("Ready (p to produce, c to consume):");
        int i;
		
        while ((i = System.in.read()) != -1) {
            char ch = (char)i;
            switch(ch) {
                case 'p':    p1.produce(); break;
                case 'c':    p1.consume(); break;
            }
        }
		
	}
}
