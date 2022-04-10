package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import flighttrack.*;

public class TestFlightManager {
    
    /**
     * Test FlightManager constructor.
     */
    @Test
    public void testFlightManager() {
        try {
            assertNotNull(new FlightManager());
        } catch (Exception e) {
            fail("Constructor for FlightManager failed: " + e.getMessage());
        }
    }
}
