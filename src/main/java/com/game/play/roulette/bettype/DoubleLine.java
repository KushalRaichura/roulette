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
 * DoubleLine.java - This class represents 'Double line' pockets i.e pockets from both lines of selected point from
 * Roulette.
 * 
 * @since 23 Sep 2018
 */
public class DoubleLine extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(DoubleLine.class);

    private static final int PAYS = 5;

    private int[] pockets;

    public DoubleLine(@JsonProperty(BETAMOUNT) int betAmount, @JsonProperty(POCKETS) int[] pockets) {
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
            LOGGER.debug("processBet() - DoubleLine bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
