package design_patterns.gof.comportamental.observer.esheadfirst;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

