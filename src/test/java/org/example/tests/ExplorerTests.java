package org.example.tests;

import org.example.entities.*;
import org.example.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ExplorerTests {
    private Explorer explorer;
    private Planet planet;
    private Person victim;
    private Spacesuit spacesuit;

    @BeforeEach
    void setUp() {
        planet = new Magrathea("Magrathea", Type.OXYGEN);
        spacesuit = new Spacesuit("Standard Suit", 100, Type.OXYGEN);
        explorer = new Explorer("Alice", 100, Type.OXYGEN, planet, true, List.of(spacesuit));
        victim = new Explorer("Charlie", 0, Type.OXYGEN, planet, false, List.of());
    }

    @Test
    void testExplorerEquipment() {
        assertEquals(1, explorer.getEquipmentList().size());
        assertEquals("Standard Suit", explorer.getEquipmentList().get(0).getName());
    }

    @Test
    void testExplorerInspectDeadPerson() {
        assertFalse(explorer.inspectBody(victim));
    }

    @Test
    void testExplorerRetrieveObjectFromDeadBody() {
        Equipment retrieved = explorer.retrieveObjectFromBody(victim, spacesuit);
        assertNotNull(retrieved);
        assertEquals("Standard Suit", retrieved.getName());
    }
}
