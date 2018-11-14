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
 * SecondHalf.java - This class represents 'Second Half' pockets i.e pockets 19 to 36 from Roulette.
 * 
 * @since 23 Sep 2018
 */

public class SecondHalf extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(SecondHalf.class);

    private static final int PAYS = 1;
    private static final int LOWER_BOUND = 19;
    private static final int UPPER_BOUND = 36;

    public SecondHalf(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        if (spinResult >= LOWER_BOUND && spinResult <= UPPER_BOUND) {
            LOGGER.debug("processBet() - SecondHalf bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
