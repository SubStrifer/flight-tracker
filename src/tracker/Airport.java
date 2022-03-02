package tracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    
    private String code;
    private String name;
    private GPSCoordinate coordinate;

    /**Airport constructor. */
    public Airport(String code, String name, GPSCoordinate coordinate) throws IllegalArgumentException {
        if (Utils.emptyOrWhitespace(code) || Utils.emptyOrWhitespace(name) ||
            coordinate == null) {
                throw new IllegalArgumentException("Airport code, name, and coordinate cannot be empty or null.");
            }
        this.setCode(code);
        this.name = name;
        this.coordinate = coordinate;
    }
    
    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    /**
     * Get distance from this Airport to the other Airport.
     * @return distance in km
     */
    public double distanceTo(Airport other) {
        double radianLatitude1 = coordinate.getLatitude() * (Math.PI / 180.0);
        double radianLongitude1 = coordinate.getLongitude() * (Math.PI / 180.0);
        double radianLatitude2 = other.coordinate.getLatitude() * (Math.PI / 180.0);
        double radianLongitude2 = other.coordinate.getLongitude() * (Math.PI / 180.0);
        double deltaLatitude = radianLatitude2 - radianLatitude1;
        double deltaLongitude = radianLongitude2 - radianLongitude1;
        double trigo = Math.sin(Math.pow(deltaLatitude / 2.0, 2)) + Math.cos(radianLatitude1) *
            Math.cos(radianLatitude2) * Math.sin(Math.pow(deltaLongitude / 2.0, 2));
        return 12742.0 * Math.asin(Math.sqrt(trigo));
    }

    /**Load all airports from a file. */
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
