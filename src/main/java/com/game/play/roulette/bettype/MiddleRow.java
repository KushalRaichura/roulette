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
 * MiddleRow.java - This class represents 'Middle row' pockets from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class MiddleRow extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(MiddleRow.class);

    private static final int PAYS = 2;

    public MiddleRow(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        BetOutcome outcome = new BetOutcome();
        if (spinResult % 3 == 2) {
            LOGGER.debug("processBet() - MiddleRow bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
