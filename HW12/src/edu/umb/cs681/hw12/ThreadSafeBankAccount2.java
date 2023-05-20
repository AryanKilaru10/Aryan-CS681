package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

import static java.lang.Thread.*;

public class ThreadSafeBankAccount2 implements BankAccount{
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();
	
	public void deposit(double amount){
		lock.lock();
		try{
			System.out.println("Lock obtained");
			System.out.println(currentThread().getId() +
					" (d): current balance: " + balance);
			while(balance >= 300){
				System.out.println(currentThread().getId() +
						" (d): await(): Balance exceeds the upper limit.");
				belowUpperLimitFundsCondition.await();
			}
			balance += amount;
			System.out.println(currentThread().getId() +
					" (d): new balance: " + balance);
			sufficientFundsCondition.signalAll();
		}
		catch (InterruptedException exception){
			System.out.println("Sleep interruption");
		}
		finally{
			lock.unlock();
			System.out.println("Lock released");
		}
	}
	
	public void withdraw(double amount){
		lock.lock();
		try{
			System.out.println("Lock obtained");
			System.out.println(currentThread().getId() +
					" (w): current balance: " + balance);
			while(balance <= 0){
				System.out.println(currentThread().getId() +
						" (w): await(): Insufficient funds");
				sufficientFundsCondition.await();
			}
			balance -= amount;
			System.out.println(currentThread().getId() +
					" (w): new balance: " + balance);
			belowUpperLimitFundsCondition.signalAll();
		}
		catch (InterruptedException exception){
			System.out.println("Sleep interruption");
		}
		finally{
			lock.unlock();
			System.out.println("Lock released");
		}
	}

	public double getBalance() { return this.balance; }

	public static void main(String[] args){
		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
		for(int i = 0; i < 5; i++){
			DepositRunnable drunnable = new DepositRunnable(bankAccount);
			WithdrawRunnable wrunnable = new WithdrawRunnable(bankAccount);
			Thread dthread = new Thread(drunnable);
			Thread wthread = new Thread(wrunnable);
			dthread.start();
			try {
				Thread.sleep(2000);
			}catch (InterruptedException ex){
				System.out.println(ex.getLocalizedMessage());
			}
			drunnable.setDone();
			dthread.interrupt();

			wthread.start();
			try {
				Thread.sleep(2000);
			}catch (InterruptedException ex){
				System.out.println(ex.getLocalizedMessage());
			}
			wrunnable.setDone();
			wthread.interrupt();

		}
	}
}
