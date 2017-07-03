package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleGameTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outContent);
    private ConsoleGame consoleGame = new ConsoleGame(printStream);

    @Test
    public void startPrintsStartMessage() {
        consoleGame.start();
        String[] expected = {
                "Welcome to Tic Tac Toe!",
                "Type <I> for instructions or <N> for new game, type <Q> at any time to exit: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void afterStartInputOfIPrintsInstructions() {
        consoleGame.start();
        outContent.reset();
        consoleGame.next("I");
        String[] expected = {
                "Enter your move by typing the name of the square on the board:",
                " tl  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Type <N> for new game or <Q> to quit: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void startNewGamePrintsEmptyBoardAndPromptsForPlayerXMove() {
        consoleGame.start();
        outContent.reset();
        consoleGame.next("N");
        String[] expected = {
            " tl  | tm  | tr",
            "----- ----- ----",
            " ml  | mm  | mr",
            "----- ----- ----",
            " bl  | bm  | br",
            "Player X: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void afterFirstMovePrintsCurrentBoardAndPromptsForPlayerOMove() {
        startGame();
        outContent.reset();
        consoleGame.next("tl");
        String[] expected = {
                "  X  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player O: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void afterSecondMovePrintsCurrentBoardAndPromptsForPlayerXMove() {
        startGame();
        consoleGame.next("tl");
        outContent.reset();
        consoleGame.next("tm");
        String[] expected = {
                "  X  |  O  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player X: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void warnsWhenInvalidSquareReferenceProvidedByPlayerX() {
        startGame();
        outContent.reset();
        consoleGame.next("invalid square reference");
        String[] expected = {
                "Oops! Invalid move, try again!",
                " tl  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player X: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void warnsWhenInvalidSquareReferenceProvidedByPlayerO() {
        startGame();
        consoleGame.next("tr");
        outContent.reset();
        consoleGame.next("invalid square reference");
        String[] expected = {
                "Oops! Invalid move, try again!",
                " tl  | tm  |  X",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player O: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void warnsWhenSquareAlreadyTaken() {
        startGame();
        consoleGame.next("tr");
        outContent.reset();
        consoleGame.next("tr");
        String[] expected = {
                "Oops! That square is already taken!",
                " tl  | tm  |  X",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player O: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void confirmsWinnerAfterWinningMoveByPlayerX() {
        startGame();
        consoleGame.next("tl");
        consoleGame.next("mr");
        consoleGame.next("tm");
        consoleGame.next("mm");
        outContent.reset();
        consoleGame.next("tr");
        String[] expected = {
                "  X  |  X  |  X",
                "----- ----- ----",
                " ml  |  O  |  O",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player X Wins!!",
                "Press <Y> to play again, or <Q> to exit: "
        };
        assertLinesEqual(expected);
    }

    @Test void startsNewGameOnEnterYWhenGameOver() {
        startGame();
        consoleGame.next("tl");
        consoleGame.next("mr");
        consoleGame.next("tm");
        consoleGame.next("mm");
        consoleGame.next("tr");
        outContent.reset();
        consoleGame.next("Y");
        String[] expected = {
                " tl  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player X: "
        };
        assertLinesEqual(expected);
    }

    @Test void doesntStartNewGameOnEnterYWhenGameStillActive() {
        startGame();
        consoleGame.next("tl");
        outContent.reset();
        consoleGame.next("Y");
        String[] expected = {
                "Oops! Invalid move, try again!",
                "  X  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br",
                "Player O: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void confirmsWinnerAfterWinningMoveByPlayerO() {
        startGame();
        consoleGame.next("tl");
        consoleGame.next("mr");
        consoleGame.next("tm");
        consoleGame.next("mm");
        consoleGame.next("br");
        outContent.reset();
        consoleGame.next("ml");
        String[] expected = {
                "  X  |  X  | tr",
                "----- ----- ----",
                "  O  |  O  |  O",
                "----- ----- ----",
                " bl  | bm  |  X",
                "Player O Wins!!",
                "Press <Y> to play again, or <Q> to exit: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void reportsDrawOnStalemate() {
        startGame();
        consoleGame.next("tl");
        consoleGame.next("tr");
        consoleGame.next("tm");
        consoleGame.next("ml");
        consoleGame.next("mm");
        consoleGame.next("bm");
        consoleGame.next("mr");
        consoleGame.next("br");
        outContent.reset();
        consoleGame.next("bl");
        String[] expected = {
                "  X  |  X  |  O",
                "----- ----- ----",
                "  O  |  X  |  X",
                "----- ----- ----",
                "  X  |  O  |  O",
                "It's a draw!!",
                "Press <Y> to play again, or <Q> to exit: "
        };
        assertLinesEqual(expected);
    }

    @Test
    public void typingQquitsConsoleGame() {
        startGame();
        outContent.reset();
        consoleGame.next("Q");
        assertEquals("Bye Bye!", outContent.toString());
        assertTrue(consoleGame.isQuit());
    }

    private void assertLinesEqual(String[] expected) {
        assertEquals(String.join("\n", expected), outContent.toString());
    }

    private void startGame() {
        consoleGame.start();
        consoleGame.next("N");
    }
}