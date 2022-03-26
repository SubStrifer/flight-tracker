package flight.tracking.system;

public interface Subject {
	
	/**
	 * Register an observer with this subject
	 */
	public void registerObserver(Observer obs);

	/**
	 * De-register an observer with this subject
	 */
	public void removeObserver(Observer obs);

	/**
	 * Inform all registered observers that there's been an update
	 */
	public void notifyObservers();
}