package Threads01.demo3;

public class app {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
		
			@Override
			public void run() {
			Thread.currentThread().setName("only thread");
				for (int i = 0; i < 10; i++) {
					System.out.println("Looping !!!!"+  Thread.currentThread().getName() +" with value "+ i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		t1.start();
	}

}
