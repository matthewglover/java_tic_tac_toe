package com.matthewglover.tictactoe;

import com.sun.istack.internal.NotNull;

import java.io.PrintStream;
import java.util.Arrays;

public class ConsoleGame {

    private PrintStream output;
    private Game game;
    private BoardRenderer boardRenderer;
    private boolean isQuit;

    public ConsoleGame(PrintStream output) {
        this.output = output;
    }

    public void start() {
        output.println("Welcome to Tic Tac Toe!");
        output.print("Type <I> for instructions or <N> for new game, type <Q> at any time to exit: ");
    }

    public void next(String input) {
       if (isFirstRun() && input.equals("N")) {
           startNewGame();
       }
       else if (isCompletedGame() && input.equals("Y")) {
           startNewGame();
       }
       else if (input.equals("Q")) {
           runQuit();
       }
       else {
           tryMove(input);
       }
    }

    public boolean isQuit() {
        return isQuit;
    }

    private boolean isFirstRun() {
       return game == null;
    }

    private boolean isCompletedGame() {
        return !isFirstRun() && game.getGameStatus().isGameOver;
    }

    private void startNewGame() {
        buildNewGame();
        promptForPlayerMove();
    }

    private void buildNewGame() {
        game = new Game();
        boardRenderer = new BoardRenderer(game.getBoard());
    }

    private void printBoard() {
        Arrays.stream(boardRenderer.getRenderLines()).forEach(line -> output.println(line));
    }

    private void promptForPlayerMove() {
        String playerName = playerToString(game.getCurrentPlayer());
        printBoard();
        output.print(String.format("Player %s: ", playerName));
    }

    private void tryMove(String input) {
        makeMove(input);
        if (game.getGameStatus().isWinner) {
            reportWinner();
        } else {
            promptForPlayerMove();
        }
    }

    private void reportWinner() {
        String playerName = playerToString(game.getGameStatus().winner);
        printBoard();
        output.println(String.format("Player %s Wins!!", playerName));
        output.print("Press <Y> to play again, or <Q> to exit: ");
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

    private void runQuit() {
        isQuit = true;
        output.print("Bye Bye!");
    }
}
