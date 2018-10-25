/**
 * Module: roulette
 */
package com.game.play.roulette.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * RandomNumberGenerator.java - This class is used to facilitate generation of random int number between 0 and 36 i.e
 * MAXLIMIT
 * 
 * @since 23 Sep 2018
 */
@Component
public class RandomNumberGenerator {

    private final static Logger LOGGER = LoggerFactory.getLogger(RandomNumberGenerator.class);

    private Random random = new Random();
    private static final int MAXLIMIT = 37;

    public int getRandomNumber() {
        LOGGER.info("Entering getRandomNumber()");
        int randomNumber = random.nextInt(MAXLIMIT);
        LOGGER.info("Exiting getRandomNumber(), generated random number {}", randomNumber);
        return randomNumber;
    }
}
