package org.example.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArctgTests {
    public static double arctg(double x, int terms) {
        if (Math.abs(x) > 1) {
            throw new IllegalArgumentException("only valid for |x| ≤ 1");
        }
        double result = 0.0;
        for (int n = 0; n < terms; n++) {
            double term = Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
            result += term;
        }
        return result;
    }


    @Test
    void TestZero() {
        assertEquals(0.0, arctg(0, 10), 1e-6);
    }

    @Test
    void TestOne() {
        assertEquals(Math.PI / 4, arctg(1, 300000), 1e-6);
    }

    @Test
    void TestMinusOne() {
        assertEquals(-Math.PI / 4, arctg(-1, 300000), 1e-6);
    }

    @Test
    void TestHalf() {
        assertEquals(Math.atan(0.5), arctg(0.5, 20), 1e-6);
    }

    @Test
    void testMinusHalf() {
        assertEquals(Math.atan(-0.5), arctg(-0.5, 20), 1e-6);
    }

    @Test
    void testNearOne() {
        assertEquals(Math.atan(0.999), arctg(0.999, 3000), 1e-6);
    }

    @Test
    void testNearMinusOne() {
        assertEquals(Math.atan(-0.999), arctg(-0.999, 3000), 1e-6);
    }

    @Test
    void testDivergenceOutsideRadius() {
        assertThrows(IllegalArgumentException.class, () -> arctg(1.1, 10));
    }
}
