package edu.umb.cs680.observer;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable<WKSummary> {
	private LinkedList<Observer<WKSummary>> observers = new LinkedList<>();
	
	public void addObserver(Observer<WKSummary> o) {
		observers.add(o);
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<WKSummary>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<WKSummary> o) {
		observers.remove(o);
	}

	public void notifyObservers(WKSummary event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}
	
}
