package org.example.tests;

import org.example.entities.Magrathea;
import org.example.entities.Planet;
import org.example.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanetTests {
    private Planet planet;

    @BeforeEach
    void setUp() {
        planet = new Magrathea("Magrathea", Type.OXYGEN);
    }

    @Test
    void testPlanetProperties() {
        assertEquals("Magrathea", planet.getName());
        assertEquals(Type.OXYGEN, planet.getType());
    }
}
