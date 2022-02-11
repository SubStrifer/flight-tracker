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

/**
 * FlightManager is the main class of the FlightTracker.
 */
public class FlightManager {

    private FlightTrackerGUI gui;

    /**
     * FlightManager constructor.
     */
    public FlightManager() {
        gui = new FlightTrackerGUI();
    }

    public static void main(String[] args) {
       FlightManager manager = new FlightManager();
    }
 }