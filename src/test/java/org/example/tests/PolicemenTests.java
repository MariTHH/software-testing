package org.example.tests;

import org.example.entities.Policemen;
import org.example.entities.Weapon;
import org.example.enums.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PolicemenTests {

    @ParameterizedTest
    @CsvSource({
            "Bob, 100, OXYGEN, Laser Gun, 50",
            "Alice, 80, CO2, Plasma Rifle, 70",
            "Charlie, 120, OXYGEN, Taser, 30"
    })
    void testPolicemenWeaponHandling(String name, int health, Type type, String weaponName, int damage) {
        Weapon weapon = new Weapon(weaponName, damage, null);
        Policemen policemen = new Policemen(name, health, type, null, true, List.of(weapon), false, 100);

        policemen.holdWeapon();
        assertTrue(policemen.isHoldingWeapon());

        policemen.dropWeapon();
        assertFalse(policemen.isHoldingWeapon());
    }
}
