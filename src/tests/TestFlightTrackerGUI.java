package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import flighttrack.*;

public class TestFlightTrackerGUI {
    
    /**
     * Test FlightTrackerGUI constructor.
     */
    @Test
    public void testFlightTrackerGUI() {
        try {
            assertNotNull(new FlightTrackerGUI(new FlightManager()));
        } catch (Exception e) {
            fail("Constructor for FlightTrackerGUI failed: " + e.getMessage());
        }
    }
}
