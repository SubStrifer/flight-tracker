/**
 * The FlightTracker program tracks planes from different airlines flying between aiports.
 *
 * @author Krzysztof Czerwinski
 * @author Namitha Narayanan
 * @author Naitik Patel
 * @author Muzzammil Haqani
 * @version 1.0
 */
package tracker;

import java.util.ArrayList;

/**
 * FlightManager is the main class of the FlightTracker.
 */
public class FlightManager {

    private FlightTrackerGUI gui;
    private ArrayList<Airport> airports;
    private ArrayList<Aeroplane> planes;

    /**
     * FlightManager constructor.
     */
    public FlightManager() {
        gui = new FlightTrackerGUI();
        airports = Airport.loadAirports();
        planes = Aeroplane.loadAeroplanes();
    }

    public static void main(String[] args) {
       FlightManager manager = new FlightManager();
    }
 }