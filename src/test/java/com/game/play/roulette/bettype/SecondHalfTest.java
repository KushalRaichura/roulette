package com.game.play.roulette.bettype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

public class SecondHalfTest {

    @Test
    public void testProcessBetWon() {
        Bet bet = new SecondHalf(10);
        bet.processBet(19);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(true, 20);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetLost() {
        Bet bet = new SecondHalf(10);
        bet.processBet(18);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(false, 0);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

}
