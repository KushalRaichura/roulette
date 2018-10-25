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
 * Line.java - This class represents 'Line' pockets i.e pockets from selected line.
 * 
 * @since 23 Sep 2018
 */
public class Line extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Line.class);

    private static final int PAYS = 11;

    private int[] pockets;

    public Line(@JsonProperty(BETAMOUNT) int betAmount, @JsonProperty(POCKETS) int[] pockets) {
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
        BetOutcome outcome = new BetOutcome();
        Arrays.sort(this.pockets);
        if (Arrays.binarySearch(pockets, spinResult) >= 0) {
            LOGGER.debug("processBet() - Line bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
