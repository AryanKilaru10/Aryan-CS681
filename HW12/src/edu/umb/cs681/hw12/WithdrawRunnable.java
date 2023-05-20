package edu.umb.cs681.hw12;

import java.time.Duration;
import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable{
	private BankAccount account;
	private boolean Done = false;
	private ReentrantLock lock = new ReentrantLock();
	public void setDone(){
		lock.lock();
		try {
			Done = true;
		}finally {
			lock.unlock();
		}
	}
	
	public WithdrawRunnable(BankAccount account) {
		this.account = account;
	}
	
	public void run(){
		try{
			for(int i = 0; i < 10; i++){
				if(Done){
					System.out.println("Stopping Withdraw Method");
				}
				account.withdraw(100);
				Thread.sleep( 2000);
			}
		}catch(InterruptedException exception){
			System.out.println("Interrupting sleep");
		}
	}
}
