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
        gui = new FlightTrackerGUI();
        airports = Airport.loadAirports();
        planes = Aeroplane.loadAeroplanes();
        airlines = Airline.loadAirlines();
        flights = Flight.loadFlights(this);
    }

    public static void main(String[] args) {
       FlightManager manager = new FlightManager();
       
    }

    public Aeroplane getAeroplane(String model) throws NoSuchElementException {
        for (Aeroplane plane : planes) {
            if (plane.getModel().equals(model))
                return plane;
        }
        throw new NoSuchElementException("Aeroplane " + model + " does not exist.");
    }

    public Airport getAirport(String code) throws NoSuchElementException {
        for (Airport airport : airports) {
            if (airport.getCode().equals(code))
                return airport;
        }
        throw new NoSuchElementException("Airport " + code + " does not exist.");
    }
 }