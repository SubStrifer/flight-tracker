package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import tracker.*;

public class TestAeroplane {
    
    /**
     * Test Aeroplane constructor.
     */
    @Test
    public void testAeroplane() {
        assertNotNull(new Aeroplane("A123", "Abc", 100f, 100f));
        assertThrows(IllegalArgumentException.class, () -> new Aeroplane("", "Abc", 100f, 200f));
        assertThrows(IllegalArgumentException.class, () -> new Aeroplane("A123", "", 100f, 200f));
        assertThrows(IllegalArgumentException.class, () -> new Aeroplane("A123", "Abc", 100f, 0f));
        assertThrows(IllegalArgumentException.class, () -> new Aeroplane("A123", "Abc", -100f, 200f));
    }

    /**
     * Test Aeroplane getters.
     */
    @Test
    public void testAeroplaneGet() {
        Aeroplane plane = new Aeroplane("A123", "Abc", 100f, 200f);
        assertEquals("A123", plane.getModel());
        assertTrue(Math.abs(200f - plane.getConsumption()) < .01f);
    }
}
