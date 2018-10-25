/**
 * Module: roulette
 */
package com.game.play.roulette.io;

/**
 * 
 * BetOutcome.java - This class hold result of Bet
 * 
 * @since 23 Sep 2018
 */
public class BetOutcome {

    private boolean won;
    private int resultAmount;

    public BetOutcome() {}

    public BetOutcome(boolean won, int resultAmount) {
        super();
        this.won = won;
        this.resultAmount = resultAmount;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public int getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(int resultAmount) {
        this.resultAmount = resultAmount;
    }

}
