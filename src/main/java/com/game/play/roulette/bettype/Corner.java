/**
 * Module: roulette
 */
package com.game.play.roulette.bettype;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

/**
 * 
 * Corner.java - This class represents 'Corner' pockets from Roulette.
 * 
 * @since 23 Sep 2018
 */
public class Corner extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Corner.class);

    private static final int PAYS = 8;

    private int[] pockets;

    public Corner(@JsonProperty(BETAMOUNT) int betAmount, @JsonProperty(POCKETS) int[] pockets) {
        super(betAmount);
        this.pockets = pockets;
    }

    public int[] getPockets() {
        return pockets;
    }

    public void setPockets(int[] pockets) {
        this.pockets = pockets;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processBet(int spinResult) {
        LOGGER.info("Entering processBet()");
        Arrays.sort(this.pockets);
        if (Arrays.binarySearch(pockets, spinResult) >= 0) {
            LOGGER.debug("processBet() - Corner bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
