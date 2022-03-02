package tracker;

import java.util.ArrayList;
import java.util.List;

/**Airports (Towers) to be crossed in one Flight. */
public class FlightPlan {
    
    private ArrayList<Airport> airports;

    /**Default constructor. */
    public FlightPlan(Airport departure, Airport destination, List<Airport> airports) throws IllegalArgumentException {
        this.airports = new ArrayList<Airport>(airports);

        if (airports.size() < 2) {
            throw new IllegalArgumentException("Flight need to cross at least two towers.");
        } else if (airports.size() > 20) {
            throw new IllegalArgumentException("Flight cannot cross more than 20 towers.");
        } else if (departure != getDeparture() || destination != getDestination()) {
            throw new IllegalArgumentException("Departure or destination airport differ from towers crossed.");
        }
    }

    /**Get the first Airport in the Flight. */
    public Airport getDeparture() {
        //todo should throw out of bounds
        return airports.get(0);
    }

    /**Get the last Airport in the Flight. */
    public Airport getDestination() {
        //todo should throw out of bounds
        return airports.get(airports.size() - 1);
    }
}
