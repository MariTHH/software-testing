package org.example.tests;

import org.example.entities.Spacesuit;
import org.example.entities.Weapon;
import org.example.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentTests {
    private Spacesuit spacesuit;
    private Weapon weapon;

    @BeforeEach
    void setUp() {
        spacesuit = new Spacesuit("Standard Suit", 100, Type.OXYGEN);
        weapon = new Weapon("Laser Gun", 50, null);
    }

    @Test
    void testSpacesuitFrazzle() {
        assertEquals(100, spacesuit.getFrazzle());
    }

    @Test
    void testSpacesuitType() {
        assertEquals(Type.OXYGEN, spacesuit.getType());
    }

    @Test
    void testWeaponOwnership() {
        assertNull(weapon.getOwner());
    }
}
