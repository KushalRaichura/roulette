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
 * FourBet.java - This class represents 'FourBet' pockets i.e pockets 0 to 3 from Roulette. This is special Double line
 * type bet.
 * 
 * @since 23 Sep 2018
 */
public class FourBet extends Bet {

    private final static Logger LOGGER = LoggerFactory.getLogger(FourBet.class);

    private static final int PAYS = 8;

    private int[] pockets = new int[] { 0, 1, 2, 3 };

    public FourBet(@JsonProperty(BETAMOUNT) int betAmount) {
        super(betAmount);
    }

    public int[] getPockets() {
        return pockets;
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
            LOGGER.debug("processBet() - FourBet bet successful");
            outcome.setResultAmount(this.getBetAmount() + this.getBetAmount() * PAYS);
            outcome.setWon(true);
        }
        this.setBetOutcome(outcome);
        LOGGER.info("Exiting processBet()");
    }

}
