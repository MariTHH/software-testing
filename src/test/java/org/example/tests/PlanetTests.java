package org.example.tests;

import org.example.entities.Magrathea;
import org.example.entities.Planet;
import org.example.enums.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class PlanetTests {

    @ParameterizedTest
    @CsvSource({
            "Magrathea, OXYGEN",
            "KappaBlagulona, METHAN",
            "Mars, OXYGEN"
    })
    void testPlanetProperties(String name, Type type) {
        Planet planet = new Magrathea(name, type);
        assertEquals(name, planet.getName());
        assertEquals(type, planet.getType());
    }
}
