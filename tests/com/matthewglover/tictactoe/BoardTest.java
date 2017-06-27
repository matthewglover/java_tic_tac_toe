package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board = new Board();

    @Test
    public void emptyBoard() {
        assertFalse(board.isComplete());
    }

    @Test
    public void completeTopRowOfXs() {
        makeMovesForPlayer(Row.top, Player.X);
//        assertTrue(board.isComplete());
        assertTrue(board.hasWonTopRow(Player.X));
    }

    @Test
    public void completeTopRowOfOs() {
        makeMovesForPlayer(Row.top, Player.O);
//        assertTrue(board.isComplete());
        assertTrue(board.hasWonTopRow(Player.O));
    }

    @Test
    public void completeHorizontalMiddleRowOfXs() {
        makeMovesForPlayer(Row.horizontalMiddle, Player.X);
        assertTrue(board.hasWonHorizontalMiddleRow(Player.X));
    }

    @Test
    public void completeHorizontalMiddleRowOfOs() {
        makeMovesForPlayer(Row.horizontalMiddle, Player.O);
        assertTrue(board.hasWonHorizontalMiddleRow(Player.O));
    }

    @Test
    public void completeBottomRowOfXs() {
        makeMovesForPlayer(Row.bottom, Player.X);
        assertTrue(board.hasWonBottomRow(Player.X));
    }

    @Test
    public void completeBottomRowOfOs() {
        makeMovesForPlayer(Row.bottom, Player.O);
        assertTrue(board.hasWonBottomRow(Player.O));
    }

    @Test
    public void completeLeftRowOfXs() {
        makeMovesForPlayer(Row.left, Player.X);
        assertTrue(board.hasWonLeftRow(Player.X));
    }

    @Test
    public void completeLeftRowOfOs() {
        makeMovesForPlayer(Row.left, Player.O);
        assertTrue(board.hasWonLeftRow(Player.O));
    }

    @Test
    public void completeVerticalMiddleRowOfXs() {
        makeMovesForPlayer(Row.verticalMiddle, Player.X);
        assertTrue(board.hasWonVerticalMiddleRow(Player.X));
    }

    @Test
    public void completeVerticalMiddleRowOfOs() {
        makeMovesForPlayer(Row.verticalMiddle, Player.O);
        assertTrue(board.hasWonVerticalMiddleRow(Player.O));
    }

    @Test
    public void completeRightRowOfXs() {
        makeMovesForPlayer(Row.right, Player.X);
        assertTrue(board.hasWonRightRow(Player.X));
    }

    @Test
    public void completeRightRowOfOs() {
        makeMovesForPlayer(Row.right, Player.O);
        assertTrue(board.hasWonRightRow(Player.O));
    }

    private void makeMovesForPlayer(Move[] moves, Player player) {
        for (Move move : moves) {
            board.move(move, player);
        }
    }
}