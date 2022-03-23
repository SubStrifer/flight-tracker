package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import flight.tracking.system.*;

public class TestFlight {

	@Test
	 /**Test constructor. */
    public void testFlight() {
		
		 
		 Airport departure = new Airport("LHR","Heathrow",new GPSCoordinate("51°28'12.0720\"N", "0°27'15.4620\"W"));
		 Airport destination = new Airport("BOM", "Mumbai",new GPSCoordinate(" 19° 5' 50.6508\"N", "72° 52' 27.2820\"E"));
		 ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		 Flight flight = new Flight("BA12",new Aeroplane("xyz","xy12",10f,100f),LocalDateTime.now(),
		 	new FlightPlan(departure,destination,listOfAirports));
	     assertNotNull(flight);
	}
		 
		 
 
    
	@Test
    /**
     * Test Get Airline code of the flight.
     */
    public void testgetAirlineCode() {
    	Airport departure = new Airport("LHR","Heathrow",new GPSCoordinate("51°28'12.0720\"N", "0°27'15.4620\"W"));
		 Airport destination = new Airport("BOM", "Mumbai",new GPSCoordinate(" 19° 5' 50.6508\"N", "72° 52' 27.2820\"E"));
		 ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		 Flight flight = new Flight("BA12",new Aeroplane("xyz","xy12",10f,100f),LocalDateTime.now(),
		 	new FlightPlan(departure,destination,listOfAirports));
    	assertEquals(flight.getAirlineCode(),"BA");
    }

	
	@Test
    /**
     * Test Get distance traveled during the entire flight.
     */
    public void testgetDistance() {
    	Airport departure = new Airport("LHR","Heathrow",new GPSCoordinate("51°28'12.0720\"N", "0°27'15.4620\"W"));
		 Airport destination = new Airport("BOM", "Mumbai",new GPSCoordinate(" 19° 5' 50.6508\"N", "72° 52' 27.2820\"E"));
		 ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		 listOfAirports.add(departure);
		 listOfAirports.add(destination);
		 Flight flight = new Flight("BA12",new Aeroplane("xyz","xy12",10f,100f),LocalDateTime.now(),
		 	new FlightPlan(departure,destination,listOfAirports));
		
		assertTrue(flight.getDistance() > 0f);
        }
  
	@Test
    /**
     * Test Get total fuel used on the flight.
     */
    public void testgetConsumption() {
		
		Airport departure = new Airport("LHR","Heathrow",new GPSCoordinate("51°28'12.0720\"N", "0°27'15.4620\"W"));
		Airport destination = new Airport("BOM", "Mumbai",new GPSCoordinate(" 19° 5' 50.6508\"N", "72° 52' 27.2820\"E"));
		ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
		listOfAirports.add(departure);
		listOfAirports.add(destination);
		Flight flight = new Flight("BA12",new Aeroplane("xyz","xy12",10f,100f),LocalDateTime.now(),
		new FlightPlan(departure,destination,listOfAirports)) ;
		assertTrue(flight.getConsumption() > 0f);
    }

    @Test
    /**Test the Loading of  all flights from a file. */
    public void testloadFlights() {
    	FlightManager manager = new FlightManager();
        ArrayList<Flight> flights = Flight.loadFlights(manager);
        assertNotNull(flights);


}
}
