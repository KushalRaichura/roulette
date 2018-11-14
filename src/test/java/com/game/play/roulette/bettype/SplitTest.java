package com.game.play.roulette.bettype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

public class SplitTest {

    @Test
    public void testProcessBetWon() {
        Bet bet = new Split(10, new int[] { 31, 34 });
        bet.processBet(31);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(true, 180);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetLost() {
        Bet bet = new Split(10, new int[] { 31, 34 });
        bet.processBet(3);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(false, 0);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

}
