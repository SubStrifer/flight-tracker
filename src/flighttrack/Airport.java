package flighttrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Airport extends Thread {
    
    private String code;
    private String name;
    private GPSCoordinate coordinate;
    private HashMap<Flight, GPSCoordinate> positions;
    private List<Observer> registeredObservers = new LinkedList<Observer>();

    /**
     * Airport constructor.
     */
    public Airport(String code, String name, GPSCoordinate coordinate) throws IllegalArgumentException {
        if (Utils.emptyOrWhitespace(code) || Utils.emptyOrWhitespace(name) ||
            coordinate == null) {
                throw new IllegalArgumentException("Airport code, name, and coordinate cannot be empty or null.");
            }
        this.setCode(code);
        this.name = name;
        this.coordinate = coordinate;
        this.positions = new HashMap<Flight, GPSCoordinate>();
        start();
    }

    public GPSCoordinate getCoordinate() {
        return coordinate;
    }
    
    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public void run() {
        while(true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Check if simulation should be updated
            if (FlightManager.getUpdateSimulation())
            {
                notifyObservers();
            }
        }
    }

	/**
	 * Register an observer with this subject
	 */
	public void registerObserver(Observer obs) {
		registeredObservers.add(obs);
	}

	/**
	 * De-register an observer with this subject
	 */
	public void removeObserver(Observer obs) {
		registeredObservers.remove(obs);
	}

	/**
	 * Inform all registered observers that there's been an update
	 */
	public synchronized void notifyObservers() {
		for (Observer obs : registeredObservers) {
            obs.update(this, positions);
        }
	}

    /**
     * Notify tower of the position of the flight.
     */
    public synchronized void updatePosition(Flight flight, GPSCoordinate position, boolean remove) {
        if (!remove) {
            // Log if the flight just started communication with this tower
            if (!positions.containsKey(flight)) {
                Logger.getInstance().log("Flight " + flight.toString() + " started communication with tower " + name);
            }
            positions.put(flight, position);
        } else {
            positions.remove(flight);
        }
    }

    /**
     * Get distance from this Airport to the other Airport.
     * @return distance in km
     */
    public double distanceTo(Airport other) {
        return coordinate.distanceTo(other.coordinate);
    }

    /**
     * Load all airports from a file.
     */
    public static ArrayList<Airport> loadAirports() {
        ArrayList<Airport> airports = new ArrayList<Airport>();

        // Create Airport from each line
        for (String line : Resources.getInstance().loadResource("airports.txt")) {
            try {
                String[] airport = line.split(";");
                GPSCoordinate coordinate = new GPSCoordinate(airport[2], airport[3]);
                airports.add(new Airport(airport[0].trim(), airport[1].trim(), coordinate));
            } catch (Exception e) {
                System.out.println("Could not parse airport data, skipping.");
            }
        }

        return airports;
    }
}
