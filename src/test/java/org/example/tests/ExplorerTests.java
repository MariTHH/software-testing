package org.example.tests;

import org.example.entities.*;
import org.example.enums.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ExplorerTests {

    @ParameterizedTest
    @CsvSource({
            "Alice, 100, OXYGEN, Magrathea",
            "Bob, 50, METHAN, Earth",
            "Eve, 150, OXYGEN, Mars"
    })
    void testExplorerEquipment(String name, int health, Type type, String planetName) {
        Planet planet = new Magrathea(planetName, type);
        Spacesuit spacesuit = new Spacesuit("Standard Suit", 100, type);
        Explorer explorer = new Explorer(name, health, type, planet, true, List.of(spacesuit));

        assertEquals(1, explorer.getEquipmentList().size());
        assertEquals("Standard Suit", explorer.getEquipmentList().get(0).getName());
    }
}