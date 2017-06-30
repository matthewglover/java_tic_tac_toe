package com.matthewglover.tictactoe;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleGame consoleGame = new ConsoleGame(System.out);

        consoleGame.start();
        while (!consoleGame.isQuit()) {
            consoleGame.next(scanner.next());
        }
    }
}
