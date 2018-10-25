/**
 * Module: roulette
 */
package com.game.play.roulette.bettype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

/**
 * 
 * Dozen2.java - This class represents 'Dozen2' pockets i.e pockets 13 to 24 from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Dozen2 extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Dozen2.class);

    private static final int PAYS = 2;
    private static final int LOWER_BOUND = 13;
    private static final int UPPER_BOUND = 24;

    public Dozen2(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        BetOutcome outcome = new BetOutcome();
        if (spinResult >= LOWER_BOUND && spinResult <= UPPER_BOUND) {
            LOGGER.debug("processBet() - Dozen2 bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
