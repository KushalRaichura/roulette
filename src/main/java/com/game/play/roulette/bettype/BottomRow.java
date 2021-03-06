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
 * BottomRow.java - This class represents 'Bottom row' pockets from Roulette.
 * 
 */

public class BottomRow extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(BottomRow.class);

    private static final int PAYS = 2;

    public BottomRow(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        if (spinResult % 3 == 1) {
            LOGGER.debug("processBet() - Bottom row bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
