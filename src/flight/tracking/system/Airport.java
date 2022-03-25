package flight.tracking.system;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Airport extends Thread {
    
    private String code;
    private String name;
    private GPSCoordinate coordinate;
    private HashMap<Flight, GPSCoordinate> positions;

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
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //todo remove flights if no notify for a long time
        //notify GUI
    }

    /**
     * Notify tower of the position of the flight.
     */
    public synchronized void updatePosition(Flight flight, GPSCoordinate position) {
        positions.put(flight, position);
        System.out.println("Position updated");
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
        List<String> lines = new ArrayList<String>();

        // Read file
        try {
            lines = Files.readAllLines(Paths.get("data/airports.txt"));
        } catch (IOException e) {
            System.out.println("Could not read airports file.");
            return airports;
        }

        // Create Airport from each line
        for (String line : lines) {
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
