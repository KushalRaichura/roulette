/**
 * Module: roulette
 */
package com.game.play.roulette.io;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.game.play.roulette.bettype.Black;
import com.game.play.roulette.bettype.BottomRow;
import com.game.play.roulette.bettype.Corner;
import com.game.play.roulette.bettype.DoubleLine;
import com.game.play.roulette.bettype.Dozen1;
import com.game.play.roulette.bettype.Dozen2;
import com.game.play.roulette.bettype.Dozen3;
import com.game.play.roulette.bettype.Even;
import com.game.play.roulette.bettype.FirstHalf;
import com.game.play.roulette.bettype.FourBet;
import com.game.play.roulette.bettype.Line;
import com.game.play.roulette.bettype.MiddleRow;
import com.game.play.roulette.bettype.Number;
import com.game.play.roulette.bettype.Odd;
import com.game.play.roulette.bettype.Red;
import com.game.play.roulette.bettype.SecondHalf;
import com.game.play.roulette.bettype.Split;
import com.game.play.roulette.bettype.TopRow;

/**
 * 
 * Bet.java - Abstract class to represents different types of Bets. If you wish to add a new type bet, new bet class
 * should extend this class, implement processBet method and should be added here to list of '@JsonSubTypes'
 * 
 * @since 23 Sep 2018
 */
// @JsonInclude(Include.NON_NULL)
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = Number.class),

        @Type(value = Red.class),
        @Type(value = Black.class),

        @Type(value = TopRow.class),
        @Type(value = MiddleRow.class),
        @Type(value = BottomRow.class),
        @Type(value = Corner.class),

        @Type(value = Dozen1.class),
        @Type(value = Dozen2.class),
        @Type(value = Dozen3.class),

        @Type(value = Odd.class),
        @Type(value = Even.class),

        @Type(value = FirstHalf.class),
        @Type(value = SecondHalf.class),

        @Type(value = FourBet.class),
        @Type(value = Line.class),
        @Type(value = DoubleLine.class),
        @Type(value = Split.class),

})
public abstract class Bet {

    public static final String BETAMOUNT = "betAmount";
    public static final String POCKETS = "pockets";

    private int betAmount;

    private BetOutcome betOutcome;

    public Bet(int betAmount) {
        this.betAmount = betAmount;
        this.betOutcome = new BetOutcome();
    }

    /**
     * 
     * processBet - this method processed a bet and generates a result based on spinResult. All (bet) classes should
     * provide be-spoke implementation of processBet
     *
     * @param spinResult
     */
    public abstract void processBet(final int spinResult);

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public BetOutcome getBetOutcome() {
        return betOutcome;
    }

    public void setBetOutcome(BetOutcome betOutcome) {
        this.betOutcome = betOutcome;
    }

}
