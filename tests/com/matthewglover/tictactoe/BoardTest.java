package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void completeRowOfXsReportsWinningRow() throws IllegalMoveException {
        checkCompletedRowForPlayer(Player.X);
    }

    @Test
    public void completeRowOfOsReportsWinningRow() throws IllegalMoveException {
        checkCompletedRowForPlayer(Player.O);
    }

    @Test
    public void whenNoWinnerReportsNull() {
        Board board = new Board();
        assertNull(board.getWinner());
    }

    @Test
    public void reportsPlayerOWinsCorrectly() throws IllegalMoveException {
        checkReportsCorrectWinner(Player.O);
    }

    @Test
    public void reportsPlayerXWinsCorrectly() throws IllegalMoveException {
        checkReportsCorrectWinner(Player.X);
    }

    @Test
    public void whenEmptyBoardReportsIncompleteBoard() {
        Board board = new Board();
        assertFalse(board.isComplete());
    }

    @Test
    public void whenCompleteBoardReportsCompleteBoard() throws IllegalMoveException {
        Board board = new Board();
        takeSquares(board, Square.values(), Player.O);
        assertTrue(board.isComplete());
    }

    @Test
    public void whenSomeSquaresTakenReportsIncompleteBoard() throws IllegalMoveException {
        Board board = new Board();
        takeSquares(board, Arrays.copyOfRange(Square.values(), 0, 8), Player.O);
        assertFalse(board.isComplete());
    }

    @Test
    public void moveToAlreadyCompletedSquareThrowsError() throws IllegalMoveException {
        Board board = new Board();
        board.move(Square.TL, Player.O);
        Throwable exception = assertThrows(IllegalMoveException.class, () -> {
            board.move(Square.TL, Player.X);
        });
        assertEquals("Square already taken", exception.getMessage());
    }

    private void checkReportsCorrectWinner(Player player) throws IllegalMoveException {
        for (Square[] row : Row.all) {
            Board board = new Board();
            takeSquares(board, row, player);
            assertEquals(player, board.getWinner());
        }
    }
    private void checkCompletedRowForPlayer(Player player) throws IllegalMoveException {
        for (Square[] row : Row.all) {
            Board board = new Board();
            takeSquares(board, row, player);
            assertTrue(board.isWinningRow(row, player));
        }
    }

    private void takeSquares(Board board, Square[] squares, Player player) throws IllegalMoveException {
        for (Square square : squares) {
            board.move(square, player);
        }
    }
}