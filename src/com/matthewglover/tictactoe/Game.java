package com.matthewglover.tictactoe;

public class Game {

    private Board board = new Board();
    private Player currentPlayer = Player.X;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void move(Square square) throws IllegalMoveException {
        board.move(square, getCurrentPlayer());
        toggleCurrentPlayer();
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return isWinner() || board.isComplete();
    }

    public boolean isWinner() {
        return getWinner() != null;
    }

    public Player getWinner() {
        return board.getWinner();
    }

    private void toggleCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }
}
