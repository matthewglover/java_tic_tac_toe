package com.matthewglover.tictactoe;

/**
 * Created by matthewglover on 28/06/2017.
 */
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

    public GameStatus getGameStatus() {
        Player winner = board.getWinner();
        boolean isGameOver = winner != null || board.isComplete();

        return new GameStatus(isGameOver, winner);
    }

    private void toggleCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }
}
