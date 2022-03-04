package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAeroplane.class, TestAirline.class, TestAirport.class, TestFlight.class, TestFlightManager.class,
		TestFlightPlan.class, TestFlightTrackerGUI.class, TestGPSCoordinate.class })
public class AllTests {

}
