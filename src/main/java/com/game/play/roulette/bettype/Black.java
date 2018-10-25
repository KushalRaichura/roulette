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
 * Black.java - This class represents 'Black' color pockets from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Black extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Black.class);

    private static final int PAYS = 1;

    private final int[] pockets = new int[] { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };

    public Black(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        BetOutcome outcome = new BetOutcome();
        Arrays.sort(this.pockets);
        if (Arrays.binarySearch(pockets, spinResult) >= 0) {
            LOGGER.debug("processBet() - Black bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }

        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
