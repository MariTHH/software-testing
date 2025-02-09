package org.example.tests;

import org.example.entities.Policemen;
import org.example.entities.Weapon;
import org.example.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PolicemenTests {
    private Policemen policemen;
    private Weapon weapon;

    @BeforeEach
    void setUp() {
        weapon = new Weapon("Laser Gun", 50, null);
        policemen = new Policemen("Bob", 100, Type.OXYGEN, null, true, List.of(weapon), false, 100);
    }

    @Test
    void testPolicemenWeaponHandling() {
        policemen.holdWeapon();
        assertTrue(policemen.isHoldingWeapon());

        policemen.dropWeapon();
        assertFalse(policemen.isHoldingWeapon());
    }

    @Test
    void testPolicemenSpacesuit() {
        assertFalse(policemen.isSpacesuitFunctional());
    }
}
