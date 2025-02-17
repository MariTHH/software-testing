package org.example.tests;

import org.example.entities.Planet;
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
            "Bob, 100, OXYGEN, Magrathea, Laser Gun, 50",
            "Alice, 80, METHAN, KappaBlagulona, Plasma Rifle, 70",
            "Charlie, 120, OXYGEN, Magrathea,Taser, 30"
    })
    void testPolicemenWeaponHandling(String name, int health, Type type, String planetName, String weaponName, int damage) {
        Weapon weapon = new Weapon(weaponName, damage, null);
        Planet planet = Planet.createPlanet(planetName, type);
        Policemen policemen = new Policemen(name, health, type, planet, true, List.of(weapon), false, 100);

        policemen.holdWeapon();
        assertTrue(policemen.isHoldingWeapon());

        policemen.dropWeapon();
        assertFalse(policemen.isHoldingWeapon());
    }
}
