package com.luptak.crxrainyhills;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RainCalculatorImplTest {

    RainCalculator calculator = new RainCalculatorImpl();

    @Test
    void whenInputValid_thenCalculatesResult() {
        int[] surfaces = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = calculator.getMaxWater(surfaces);
        assertEquals(6, result);

        surfaces = new int[] { 3, 2, 4, 1, 2 }; // reference input from RainyHills.pdf
        result = calculator.getMaxWater(surfaces);
        assertEquals(2, result);

        surfaces = new int[] { 4, 1, 1, 0, 2, 3 }; // reference input from RainyHills.pdf
        result = calculator.getMaxWater(surfaces);
        assertEquals(8, result);
    }

    @Test
    void whenInputEmpty_thenReturnsZero() {
        int[] surfaces = {};
        int result = calculator.getMaxWater(surfaces);
        assertEquals(0, result);
    }

    @Test
    void whenInputCanNotFormHole_thenReturnsZero() {
        Random rand = new Random();
        int[] surfaces = { rand.nextInt(), rand.nextInt()};
        int result = calculator.getMaxWater(surfaces);
        assertEquals(0, result);
    }

    @Test
    void whenInputNegative_thenReturnsValidResult() {
        int[] surfaces = {0, -100, 0};
        int result = calculator.getMaxWater(surfaces);
        assertEquals(100, result);
    }
}
