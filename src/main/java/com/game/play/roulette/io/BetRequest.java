/**
 * Module: roulette
 */
package com.game.play.roulette.io;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * BetRequest.java - This class is used accept input Bet input
 * 
 * @since 23 Sep 2018
 */
public class BetRequest {

    @NotNull
    @Size(min = 1, max = 10, message = "Numbers of bets should between 1 and 10")
    List<Bet> bets;

    public BetRequest() {
        this.bets = new ArrayList<>();
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> listOfBets) {
        this.bets = listOfBets;
    }

}
