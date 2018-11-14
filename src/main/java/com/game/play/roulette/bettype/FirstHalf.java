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
 * FirstHalf.java - This class represents 'First Half' pockets i.e pockets 1 to 18 from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class FirstHalf extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(FirstHalf.class);

    private static final int PAYS = 1;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 18;

    public FirstHalf(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        if (spinResult >= LOWER_BOUND && spinResult <= UPPER_BOUND) {
            LOGGER.debug("processBet() - First bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
