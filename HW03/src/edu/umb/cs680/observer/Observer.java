package edu.umb.cs680.observer;

public interface Observer<WKSummary> {
	public void update(Observable<WKSummary> sender, WKSummary event);


}
