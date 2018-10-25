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
 * Odd.java - This class represents 'Odd' pockets i.e pockets with odd numbers from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Odd extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Odd.class);

    private static final int PAYS = 1;

    public Odd(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        BetOutcome outcome = new BetOutcome();
        if (spinResult % 2 == 1) {
            LOGGER.debug("processBet() - Odd bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
