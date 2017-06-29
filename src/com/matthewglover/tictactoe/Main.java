package com.matthewglover.tictactoe;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Welcome to Tic Tac Toe!");
//        System.out.print("Type <I> for instructions or <N> for new game: ");
//        String input = scanner.next();
        ConsoleGame consoleGame = new ConsoleGame(System.out);
        consoleGame.start();
        while (!consoleGame.isGameOver()) {
            consoleGame.next(scanner.next());
        }
    }

//    private static void runNewGame() {
//        Game game = new Game();
//        System.out.println(String.format("Player %, enter your move:", playerToString(game.getCurrentPlayer())));
//    }
//
//    @NotNull private static String playerToString(Player player) {
//        return (player == Player.X) ? "X" : "O";
//    }
}
