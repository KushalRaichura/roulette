package com.game.play.roulette.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomNumberGeneratorTest {

    @Test
    public void testGetRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertTrue(randomNumberGenerator.getRandomNumber() < 37);
    }

}
