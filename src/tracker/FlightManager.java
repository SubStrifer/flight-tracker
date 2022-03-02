/**
https://github.com/SubStrifer/flight-tracker.git * The FlightTracker program tracks planes from different airlines flying between aiports.
 *
 * @author Krzysztof Czerwinski
 * @author Namitha Narayanan
 * @author Naitik Patel
 * @author Muzzammil Haqani
 * @version 1.0
 */
package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * FlightManager is the main class of the FlightTracker.
 */
public class FlightManager {

    private FlightTrackerGUI gui;
    private ArrayList<Airport> airports;
    private ArrayList<Aeroplane> planes;
    private ArrayList<Airline> airlines;
    private ArrayList<Flight> flights;

    /**
     * FlightManager constructor.
     */
    public FlightManager() {
        gui = new FlightTrackerGUI(this);
        airports = Airport.loadAirports();
        planes = Aeroplane.loadAeroplanes();
        airlines = Airline.loadAirlines();
        flights = Flight.loadFlights(this);
    }

    public static void main(String[] args) {
       FlightManager manager = new FlightManager();
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
        HashMap<String, Integer> flights = new HashMap<String, Integer>();
        double distance = 0.0;
        for(Flight flight : this.flights) {
            // Calculate number of flights per company
            String key = flight.getAirlineCode();
            flights.putIfAbsent(key, 0);
            flights.compute(key, (k, v) -> v += 1);
            // Total number of km travelled
            distance += flight.getDistance();
        }
        //todo
        // Average total fuel consumption, estimated CO2 emission
        // Write to file
    }
 }