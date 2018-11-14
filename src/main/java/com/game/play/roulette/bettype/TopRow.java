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
 * TopRow.java - This class represents 'Top row' pockets from Roulette.
 * 
 * @since 23 Sep 2018
 */

public class TopRow extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(TopRow.class);

    private static final int PAYS = 2;

    public TopRow(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        if (spinResult % 3 == 0) {
            LOGGER.debug("processBet() - TopRow bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
