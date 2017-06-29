package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStatusTest {

    private GameStatus status = new GameStatus(true, Player.X);

    @Test
    public void hasIsGameOverProperty() {
        assertTrue(status.isGameOver);
    }

    @Test
    public void isWinnerPropertyTrueWhenWinnerNotNull() {
        assertTrue(status.isWinner);
    }

    @Test
    public void isWinnerPropertyFalseWhenWinnerNull() {
        GameStatus status = new GameStatus(true, null);
        assertFalse(status.isWinner);
    }

    @Test
    public void hasWinnerProperty() {
        assertEquals(Player.X, status.winner);
    }
}