package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void completeRowOfXsReportsWinningRow() {
        checkCompletedRowForPlayer(Player.X);
    }

    @Test
    public void completeRowOfOsReportsWinningRow() {
        checkCompletedRowForPlayer(Player.O);
    }

    @Test
    public void whenNoWinnerReportsNull() {
        Board board = new Board();
        assertNull(board.getWinner());
    }

    @Test
    public void reportsPlayerOWinsCorrectly() {
        checkReportsCorrectWinner(Player.O);
    }

    @Test
    public void reportsPlayerXWinsCorrectly() {
        checkReportsCorrectWinner(Player.X);
    }

    @Test
    public void whenEmptyBoardReportsIncompleteBoard() {
        Board board = new Board();
        assertFalse(board.isComplete());
    }

    @Test
    public void whenCompleteBoardReportsCompleteBoard() {
        Board board = new Board();
        takeSquares(board, Square.values(), Player.O);
        assertTrue(board.isComplete());
    }

    @Test
    public void whenSomeSquaresTakenReportsIncompleteBoard() {
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

    private void checkReportsCorrectWinner(Player player){
        for (Square[] row : Row.all) {
            Board board = new Board();
            takeSquares(board, row, player);
            assertEquals(player, board.getWinner());
        }
    }
    private void checkCompletedRowForPlayer(Player player) {
        for (Square[] row : Row.all) {
            Board board = new Board();
            takeSquares(board, row, player);
            assertTrue(board.isWinningRow(row, player));
        }
    }

    private void takeSquares(Board board, Square[] squares, Player player) {
        for (Square square : squares) {
            try {
                board.move(square, player);
            }
            catch (IllegalMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}