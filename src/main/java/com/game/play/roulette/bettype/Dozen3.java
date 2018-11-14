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
 * Dozen3.java - This class represents 'Dozen3' pockets i.e pockets 25 to 36 from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Dozen3 extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Dozen3.class);

    private static final int PAYS = 2;
    private static final int LOWER_BOUND = 25;
    private static final int UPPER_BOUND = 36;

    public Dozen3(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        if (spinResult >= LOWER_BOUND && spinResult <= UPPER_BOUND) {
            LOGGER.debug("processBet() - Dozen3 bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
