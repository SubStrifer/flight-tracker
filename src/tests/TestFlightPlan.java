package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import flight.tracking.system.Airport;
import flight.tracking.system.FlightPlan;
import flight.tracking.system.GPSCoordinate;

public class TestFlightPlan {
	
	private Airport departure = new Airport("FCO","Leonardo Da Vinci",new GPSCoordinate("41°46'24.7440\"N"," 12°14'22.9632\"E"));
	private Airport destination = new Airport("BOM", "Mumbai",new GPSCoordinate(" 19° 5' 50.6508\"N", "72° 52' 27.2820\"E"));
	
	@Test
	 public void testFlightPlan() {
			
		ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		 FlightPlan flightplan = new FlightPlan(departure,destination,listOfAirports);
		 ArrayList<Airport> listairport1 = new ArrayList<Airport>(Arrays.asList(
				new Airport("FCO","Leonardo Da Vinci",new GPSCoordinate("41°46'24.7440\"N"," 12°14'22.9632\"E"))));
		
				assertThrows(IllegalArgumentException.class,() -> new FlightPlan(departure,destination,listairport1));
		assertEquals(departure,flightplan.getDeparture());
		assertEquals(destination, flightplan.getDestination());
		
    }

	
	@Test
    /**Test the first Airport in the Flight. */
    public void testgetDeparture() {
    	Airport departure = new Airport("LHR","Heathrow",new GPSCoordinate("51°28'12.0720\"N","0°27'15.4620\"W"));
    	ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		FlightPlan flightplan = new FlightPlan(departure,destination,listOfAirports);
    	
       assertSame(flightplan.getDeparture(),departure);
    }

	
	@Test
    /**Test the last Airport in the Flight. */
    public void getDestination() {
      
    	Airport destination = new Airport("DXB","Dubai", new GPSCoordinate("25°15'11.7\"N","55°21'56.5\"E"));
    	ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		FlightPlan flightplan = new FlightPlan(departure,destination,listOfAirports);
    	
    	assertSame(flightplan.getDestination(),destination);
    }

    /**
     * Test the Calculate distance travelled during this entire flight.
     */
    public void testcalculateDistance() {
    	ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		FlightPlan flightplan = new FlightPlan(departure,destination,listOfAirports);
    	    	
    	assertSame(flightplan.calculateDistance(),Double.class);

    }

}
