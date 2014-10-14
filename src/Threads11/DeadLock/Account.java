package Threads11.DeadLock;

public class Account {
	
	private  int balance = 10000;
	
	public void doposit(int amount){
		balance+=amount;
	}
	public void withdraw(int amount){
		balance -= amount;
	}
	public int getBalance(){
		return balance;
	}
	
	public static void transfer(Account acc1 , Account acc2,  int amount){
		acc1.withdraw(amount);
		acc2.doposit(amount);
	}
}
