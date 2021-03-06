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
 * Line.java - This class represents 'Split' pockets i.e 2 pockets from selected line.
 * 
 * @since 23 Sep 2018
 */
public class Split extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(Split.class);

    private static final int PAYS = 17;

    private int[] pockets;

    public Split(@JsonProperty(BETAMOUNT) int betAmount, @JsonProperty(POCKETS) int[] pockets) {
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
            LOGGER.debug("processBet() - Split bet successful");
            this.setBetOutcome(new BetOutcome(true, this.getBetAmount() + this.getBetAmount() * PAYS));
        }
        LOGGER.info("Exiting processBet()");
    }

}
