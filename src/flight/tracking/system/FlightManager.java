/**
 * https://github.com/SubStrifer/flight-tracker.git
 * The FlightTracker program tracks planes from different airlines flying between aiports.
 *
 * @author Krzysztof Czerwinski
 * @author Namitha Narayanan
 * @version 1.0
 */
package flight.tracking.system;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * FlightManager is the main class of the FlightTracker.
 */
public class FlightManager {

    private Consol gui;
    private ArrayList<Airport> airports;
    private ArrayList<Aeroplane> planes;
    private ArrayList<Airline> airlines;
    private ArrayList<Flight> flights;

    /**
     * FlightManager constructor.
     */
    public FlightManager() {
        airports = Airport.loadAirports();
        planes = Aeroplane.loadAeroplanes();
        airlines = Airline.loadAirlines();
        flights = Flight.loadFlights(this);
    }

    public void setGui(Consol gui) {
        this.gui = gui;
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public ArrayList<Aeroplane> getPlanes() {
        return planes;
    }

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Get registered Aeroplane.
     * @param model name
     * @return Aeroplane object
     * @throws NoSuchElementException
     */
    public Aeroplane getAeroplane(String model) throws NoSuchElementException {
        for (Aeroplane plane : planes) {
            if (plane.getModel().equals(model))
                return plane;
        }
        throw new NoSuchElementException("Aeroplane " + model + " does not exist.");
    }

    /**
     * Get registered Airport.
     * @param code name
     * @return Airport object
     * @throws NoSuchElementException
     */
    public Airport getAirport(String code) throws NoSuchElementException {
        for (Airport airport : airports) {
            if (airport.getCode().equals(code))
                return airport;
        }
        throw new NoSuchElementException("Airport " + code + " does not exist.");
    }

    /**
     * Generate report and save it to a file.
     */
    public void generateReport() {
        String report = "Report\n";
        HashMap<String, AirlineData> flights = new HashMap<String, AirlineData>();
        double totalDistance = 0.0;
        double totalFuel = 0.0;
        for(Flight flight : this.flights) {
            // Calculate number of flights per company
            String key = flight.getAirlineCode();
            double distance = flight.getDistance();
            flights.putIfAbsent(key, new AirlineData());
            flights.get(key).flights += 1;
            flights.get(key).distance += distance;
            // Total number of km travelled
            totalDistance += distance;
            // Total liters of fuel used
            totalFuel += flight.getConsumption();
        }
        // CO2 emission, 3kg/1l of kerosene
        double carbonDioxide = totalFuel * 3.0;
        // Add number of flights per comapny to the report
        report += "Flights:\n";
        for(HashMap.Entry<String, AirlineData> entry : flights.entrySet()) {
            report += entry.getKey() + ": " + entry.getValue().flights + ", " +
                Math.round(entry.getValue().distance) + "km\n";
        }
        // Add the rest of data
        long averageFuel = Math.round((totalFuel / (totalDistance / 100.0)));
        report += "Average total fuel consumption: " + averageFuel + "l/100km\n";
        report += "Estimated total CO2 emissions: " + Math.round(carbonDioxide) + "kg\n";
        // Write to file
        try {
            Files.writeString(Paths.get("data/report.txt"), report, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Could not write report file.");
        }
    }

    private class AirlineData {
        public int flights;
        public double distance;
    }
}