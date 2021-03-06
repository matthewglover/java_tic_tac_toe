package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game = new Game();

    @Test
    public void newGameCurrentPlayerSetToX() {
        assertEquals(Player.X, game.getCurrentPlayer());
    }

    @Test
    public void afterFirstMoveCurrentPlayerSetToO() throws IllegalMoveException {
        game.move(Square.TL);
        assertEquals(Player.O, game.getCurrentPlayer());
    }

    @Test
    public void afterSecondMoveCurrentPlayerSetToX() throws IllegalMoveException {
        game.move(Square.TL);
        game.move(Square.TM);
        assertEquals(Player.X, game.getCurrentPlayer());
    }

    @Test
    public void afterThirdMoveCurrentPlayerSetToO() throws IllegalMoveException {
        game.move(Square.TL);
        game.move(Square.TM);
        game.move(Square.TR);
        assertEquals(Player.O, game.getCurrentPlayer());
    }

    @Test
    public void afterFirstMoveReturnsGameIncomplete() throws IllegalMoveException {
        game.move(Square.TL);
        assertFalse(game.isGameOver());
    }

    @Test
    public void afterWinningMoveReturnsGameOverAndWinner() throws IllegalMoveException {
        game.move(Square.TL);
        game.move(Square.ML);
        game.move(Square.MM);
        game.move(Square.MR);
        game.move(Square.BR);
        assertTrue(game.isGameOver());
        assertTrue(game.isWinner());
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    public void afterLastMoveInStalemateReturnsGameOverAndNoWinner() throws IllegalMoveException {
        game.move(Square.TL);
        game.move(Square.TM);
        game.move(Square.TR);
        game.move(Square.MR);
        game.move(Square.MM);
        game.move(Square.BL);
        game.move(Square.ML);
        game.move(Square.BR);
        game.move(Square.BM);
        assertTrue(game.isGameOver());
        assertFalse(game.isWinner());
    }
}