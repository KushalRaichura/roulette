/**
 * Module: roulette
 */
package com.game.play.roulette.bettype;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

/**
 * 
 * Red.java - This class represents 'Red' color pockets from Roulette.
 * 
 * @since 23 Sep 2018
 */

public class Red extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Red.class);

    private static final int PAYS = 1;

    private final int[] pockets = new int[] { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };

    public Red(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        Arrays.sort(this.pockets);
        if (Arrays.binarySearch(pockets, spinResult) >= 0) {
            LOGGER.debug("processBet() - Red bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
