package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import tracker.*;

public class TestGPSCoordinate {

	
	@Test
	
	    /**Default constructor. */
	    public void testGPSCoordinate() {
		
          assertNotNull(new GPSCoordinate("51°28'12.0720\"N","0°27'15.4620\"W"));
           assertThrows(CoordinateFormatException.class,() -> new GPSCoordinate("-0","-0"));
     
          
	    }

	  



}
