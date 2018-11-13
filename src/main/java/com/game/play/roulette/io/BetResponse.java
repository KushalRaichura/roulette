/**
 * Module: roulette
 */
package com.game.play.roulette.io;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * BetResponse.java - This class is used for Bet response
 * 
 * @since 23 Sep 2018
 */
// @JsonInclude(Include.NON_NULL)
public class BetResponse {
    private List<Bet> bets = new ArrayList<>();

    private int spinResult;

    public int getSpinResult() {
        return spinResult;
    }

    public void setSpinResult(int spinResult) {
        this.spinResult = spinResult;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void addBets(Bet bet) {
        this.bets.add(bet);
    }

}
