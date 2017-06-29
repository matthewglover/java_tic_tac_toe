package com.matthewglover.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleGameTest {

    private ByteArrayOutputStream outContent;
    private PrintStream printStream;
    private ConsoleGame consoleGame;

    @BeforeEach
    public void setupOutputStream() {
        outContent = new ByteArrayOutputStream();
        printStream = new PrintStream(outContent);
        consoleGame = new ConsoleGame(printStream);
    }

    @Test
    public void startPrintsStartMessage() {
        consoleGame.start();
        assertStringContains(outContent.toString(), "Welcome to Tic Tac Toe!.*Type <I> for instructions or <N> for new game:.*");
    }

    @Test
    public void startNewGamePromptsForPlayerXMove() {
        consoleGame.start();
        outContent.reset();
        consoleGame.next("N");
        assertEquals("Player X: ", outContent.toString());
    }

    @Test
    public void afterFirstMovePromptsForPlayerOMove() {
        consoleGame.start();
        consoleGame.next("N");
        outContent.reset();
        consoleGame.next("tl");
        assertEquals("Player O: ", outContent.toString());
    }

    @Test
    public void afterSecondMovePromptsForPlayerXMove() {
        consoleGame.start();
        consoleGame.next("N");
        consoleGame.next("tl");
        outContent.reset();
        consoleGame.next("tm");
        assertEquals("Player X: ", outContent.toString());
    }

    @Test
    public void warnsWhenInvalidSquareReferenceProvidedByPlayerX() {
        consoleGame.start();
        consoleGame.next("N");
        outContent.reset();
        consoleGame.next("invalid square reference");
        assertEquals("Oops! Invalid move, try again!\nPlayer X: ", outContent.toString());
    }

    @Test
    public void warnsWhenInvalidSquareReferenceProvidedByPlayerO() {
        consoleGame.start();
        consoleGame.next("N");
        consoleGame.next("tr");
        outContent.reset();
        consoleGame.next("invalid square reference");
        assertEquals("Oops! Invalid move, try again!\nPlayer O: ", outContent.toString());
    }

    @Test
    public void warnsWhenSquareAlreadyTaken() {
        consoleGame.start();
        consoleGame.next("N");
        consoleGame.next("tr");
        outContent.reset();
        consoleGame.next("tr");
        assertEquals("Oops! That square is already taken!\nPlayer O: ", outContent.toString());
    }

    private void assertStringContains(String actual, String expected) {
        Pattern p = Pattern.compile(expected, Pattern.DOTALL);
        Matcher m = p.matcher(actual);
        assertTrue(m.matches());
    }
}