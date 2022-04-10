package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import flighttrack.*;

public class TestAirline {

	@Test
	public void testAirline() {
		assertNotNull(new Airline("EDI","EdinburghAirport"));
		assertThrows(IllegalArgumentException.class, () -> new Airline("", "Abc"));
		assertThrows(IllegalArgumentException.class, () -> new Airline("Abc", ""));
		assertThrows(IllegalArgumentException.class, () -> new Airline(null,"Ab"));
		assertThrows(IllegalArgumentException.class, () -> new Airline("Abc", null));


		}
	
	@Test
	public void testloadAirplanes() {
		ArrayList<Airline> airlines = Airline.loadAirlines();
		assertNotNull(airlines);
			}
	

}
