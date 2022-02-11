package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import tracker.*;

public class TestFlightTrackerGUI {
    
    /**
     * Test FlightTrackerGUI constructor.
     */
    @Test
    public void testFlightTrackerGUI() {
        try {
            assertNotNull(new FlightTrackerGUI());
        } catch (Exception e) {
            fail("Constructor for FlightTrackerGUI failed: " + e.getMessage());
        }
    }
}
