package com.matthewglover.tictactoe;

import com.sun.istack.internal.NotNull;

import java.io.PrintStream;

public class ConsoleGame {

    private PrintStream output;
    private Game game;

    public ConsoleGame(PrintStream output) {
        this.output = output;
    }

    public void start() {
        output.println("Welcome to Tic Tac Toe!");
        output.print("Type <I> for instructions or <N> for new game: ");
    }

    public void next(String input) {
       if (!isActiveGame() && input.equals("N")) {
           startNewGame();
       }
       else {
           makeMove(input);
           promptForPlayerMove();
       }
    }

    public boolean isGameOver() {
        return false;
    }

    private boolean isActiveGame() {
       return game != null;
    }

    private void startNewGame() {
        game = new Game();
        promptForPlayerMove();
    }

    private void promptForPlayerMove() {
        String playerName = playerToString(game.getCurrentPlayer());
        output.print(String.format("Player %s: ", playerName));
    }

    private void makeMove(String input) {
        try {
            Square square = Square.valueOf(input.toUpperCase());
            game.move(square);
        } catch (IllegalMoveException e) {
            output.println("Oops! That square is already taken!");
        } catch (IllegalArgumentException e) {
            output.println("Oops! Invalid move, try again!");
        }
    }

    @NotNull private static String playerToString(Player player) {
        return (player == Player.X) ? "X" : "O";
    }
}
