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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + resultAmount;
        result = prime * result + (won ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BetOutcome other = (BetOutcome) obj;
        if (resultAmount != other.resultAmount)
            return false;
        if (won != other.won)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BetOutcome [won=" + won + ", resultAmount=" + resultAmount + "]";
    }

}
