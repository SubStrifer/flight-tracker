package flighttrack;

import java.util.HashMap;

public interface Observer {
	
	/**
	 * Tell Observer to update itself
	 */
	public void update(Airport tower, HashMap<Flight, GPSCoordinate> positions);
}