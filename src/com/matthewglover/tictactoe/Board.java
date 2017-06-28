package com.matthewglover.tictactoe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {
    public static Square[] allSquares = {
            Square.TL, Square.TM, Square.TR,
            Square.ML, Square.MM, Square.MR,
            Square.BL, Square.BM, Square.BR};

    private Map<Square, Player> boardMap = new HashMap<>();

    public void move(Square square, Player player) throws IllegalMoveException {
        if (boardMap.containsKey(square)) {
            throw new IllegalMoveException("Square already taken");
        }
        boardMap.put(square, player);
    }

    public boolean isWinningRow(Square[] row, Player player) {
        return allMovesTaken(row, player);
    }

    public Player getWinner() {
        if (isAnyWinningRow(Player.O)) {
            return Player.O;
        }
        if (isAnyWinningRow(Player.X)) {
            return Player.X;
        }
        return null;
    }

    public boolean isComplete() {
        return Arrays.stream(allSquares).allMatch(square -> boardMap.containsKey(square));
    }

    private boolean isAnyWinningRow(Player player) {
        return Arrays.stream(Row.all).anyMatch(row -> isWinningRow(row, player));
    }

    private boolean allMovesTaken(Square[] squares, Player player) {
        return Arrays.stream(squares).allMatch(square -> boardMap.get(square) == player);
    }
}