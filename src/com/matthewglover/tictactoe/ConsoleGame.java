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
       if (isQuitRequest(input)) {
           quit();
       }
       else if (isFirstRun()) {
           onFirstRun(input);
       }
       else if (isGameComplete()) {
           onGameComplete(input);
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

    private boolean isQuitRequest(String input) {
        return input.equals("Q");
    }

    private void onFirstRun(String input) {
        if (input.equals("N")) {
            startNewGame();
        } else if (input.equals("I")) {
            printInstructions();
        }
    }

    private void onGameComplete(String input) {
        if (input.equals("Y")) {
            startNewGame();
        }
    }

    private boolean isGameComplete() {
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
        printBoard(boardRenderer);
    }

    private void printBoard(BoardRenderer boardRenderer) {
        Arrays.stream(boardRenderer.getRenderLines()).forEach(line -> output.println(line));
    }

    private void printInstructions() {
        output.println("Enter your move by typing the name of the square on the board:");
        BoardRenderer boardRenderer = new BoardRenderer((new Game()).getBoard());
        printBoard(boardRenderer);
        output.print("Type <N> for new game or <Q> to quit: ");
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
        }
        else if (game.getGameStatus().isGameOver) {
            printBoard();
            output.println("It's a draw!!");
            output.print("Press <Y> to play again, or <Q> to exit: ");
        }
        else {
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

    private void quit() {
        isQuit = true;
        output.print("Bye Bye!");
    }
}
