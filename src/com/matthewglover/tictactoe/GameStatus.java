package com.matthewglover.tictactoe;

public final class GameStatus {
    public final boolean isGameOver;
    public final boolean isWinner;
    public final Player winner;

    public GameStatus(boolean isGameOver, Player winner) {
        this.isGameOver = isGameOver;
        this.isWinner = winner != null;
        this.winner = winner;
    }
}
