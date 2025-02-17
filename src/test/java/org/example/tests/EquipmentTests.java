package org.example.tests;

import org.example.entities.Spacesuit;
import org.example.enums.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentTests {
    @ParameterizedTest
    @CsvSource({
            "Standard Suit, 100, OXYGEN",
            "Heavy Suit, 200, CO2",
            "Light Suit, 50, OXYGEN"
    })
    void testSpacesuitFrazzle(String name, int frazzle, Type type) {
        Spacesuit spacesuit = new Spacesuit(name, frazzle, type);
        assertEquals(frazzle, spacesuit.getFrazzle());
    }

    @ParameterizedTest
    @CsvSource({
            "Standard Suit, OXYGEN",
            "Heavy Suit, CO2",
            "Light Suit, OXYGEN"
    })
    void testSpacesuitType(String name, Type type) {
        Spacesuit spacesuit = new Spacesuit(name, 100, type);
        assertEquals(type, spacesuit.getType());
    }

}
