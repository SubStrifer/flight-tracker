package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import flight.tracking.system.Airport;
import flight.tracking.system.GPSCoordinate;

public class TestAirport {

	@Test
	public void testAirport() {
		GPSCoordinate coordinate = new GPSCoordinate("51°28'12.0720\"N", "0°27'15.4620\"W");
		assertNotNull(new Airport("A123", "Abc", coordinate));

		assertThrows(IllegalArgumentException.class, () -> new Airport("", "Abc", coordinate));
		assertThrows(IllegalArgumentException.class, () -> new Airport("A123", "", coordinate));
		assertThrows(IllegalArgumentException.class, () -> new Airport("A123", "Abc", null));
	}

	/**
	 * Test Aeroplane getters.
	 */
	@Test
	public void testdistanctTo() {
		Airport a1 = new Airport("Abc", "abc", new GPSCoordinate("51°28'12.0720\"N", "0°27'15.4620\"W"));
		Airport a2 = new Airport("Def", "def", new GPSCoordinate("51°28'12.0720\"S", "0°27'15.4620\"E"));
		Double distance = a1.distanceTo(a2);
		assertNotNull(distance);
		assertSame(distance.getClass(), Double.class);
	}

	@Test
	public void testloadAirports() {
		ArrayList<Airport> airports = Airport.loadAirports();
		assertNotNull(airports);
	}

}
