package com.game.play.roulette.bettype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.play.roulette.io.Bet;
import com.game.play.roulette.io.BetOutcome;

public class RowTest {

    @Test
    public void testProcessBetTopRowWon() {
        Bet bet = new TopRow(10);
        bet.processBet(3);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(true, 30);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetMiddleRowLost() {
        Bet bet = new TopRow(10);
        bet.processBet(2);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(false, 0);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetMiddleRowWon() {
        Bet bet = new MiddleRow(10);
        bet.processBet(2);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(true, 30);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetTopRowLost() {
        Bet bet = new MiddleRow(10);
        bet.processBet(3);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(false, 0);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetBottomRowWon() {
        Bet bet = new BottomRow(10);
        bet.processBet(1);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(true, 30);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

    @Test
    public void testProcessBetBottomRowLost() {
        Bet bet = new BottomRow(10);
        bet.processBet(2);
        BetOutcome betOutcomeActual = bet.getBetOutcome();
        BetOutcome betOutcomeExpected = new BetOutcome(false, 0);
        assertEquals(betOutcomeExpected, betOutcomeActual);
    }

}
