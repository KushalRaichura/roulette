package com.game.play.roulette.bettype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

public class NumberTest {

    @Test
    public void testProcessBetWon() {
        Bet bet = new Number(10, 10);
        bet.processBet(10);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(true, 360);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetLost() {
        Bet bet = new Number(10, 10);
        bet.processBet(1);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(false, 0);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

}
