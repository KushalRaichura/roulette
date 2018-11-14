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
 * Odd.java - This class represents single pocket (selected number) from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Number extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Number.class);

    private static final int PAYS = 35;

    private int number;

    public Number(@JsonProperty(BETAMOUNT) int betAmount, @JsonProperty("number") int number) {
        super(betAmount);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(final int spinResult) {
        LOGGER.info("Entering processBet()");
        if (spinResult == this.number) {
            LOGGER.debug("processBet() - Number bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
