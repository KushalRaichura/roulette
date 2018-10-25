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
 * Even.java - This class represents 'Even' pockets i.e pockets with even numbers (except Zero) from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Even extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Even.class);

    private static final int PAYS = 1;

    public Even(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        BetOutcome outcome = new BetOutcome();
        if (spinResult != 0 && spinResult % 2 == 0) {
            LOGGER.debug("processBet() - Even bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
