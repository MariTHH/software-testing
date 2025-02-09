package org.example.tests;

import org.example.support.LifeSupport;
import org.example.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class LifeSupportTests {
    private LifeSupport lifeSupport;

    @BeforeEach
    void setUp() {
        lifeSupport = new LifeSupport(Type.OXYGEN, 100);
    }

    @Test
    void testLifeSupportConsumption() {
        lifeSupport.consumeResource(50);
        assertEquals(50, lifeSupport.getResourceLevel());
        assertTrue(lifeSupport.isFunctional());

        lifeSupport.consumeResource(60);
        assertFalse(lifeSupport.isFunctional());
    }

    @Test
    void testLifeSupportRecharge() {
        lifeSupport.consumeResource(100);
        assertFalse(lifeSupport.isFunctional());

        lifeSupport.recharge(50);
        assertTrue(lifeSupport.isFunctional());
        assertEquals(50, lifeSupport.getResourceLevel());
    }
}
