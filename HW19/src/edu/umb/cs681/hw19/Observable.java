package edu.umb.cs681.hw19;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable<T> {
	private ReentrantLock lock = new ReentrantLock();
	private ConcurrentLinkedQueue<Observer<T>> observers = new ConcurrentLinkedQueue<>();
	
	public void addObserver(Observer<T> o) {
			observers.add(o);

	}

	public void clearObservers() {
			observers.clear();
	}
	public ConcurrentLinkedQueue<Observer<T>> getObservers(){
			return observers;
	}
	
	public int countObservers() {
			return observers.size();

	}
	public void removeObserver(Observer<T> o) {
		lock.lock();
		try {
			observers.remove(o);
		}finally {
			lock.unlock();
		}

	}

	public void notifyObservers(T event) {
			ConcurrentLinkedQueue<Observer<T>> obsLocal = observers;
			obsLocal.forEach( (observer)->{observer.update(this, event);} );
		}

	
}
