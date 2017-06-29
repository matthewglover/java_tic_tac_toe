package com.matthewglover.tictactoe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Square, Player> boardMap = new HashMap<>();

    public void move(Square square, Player player) throws IllegalMoveException {
        if (boardMap.containsKey(square)) {
            throw new IllegalMoveException("Square already taken");
        }
        boardMap.put(square, player);
    }

    public boolean isWinningRow(Square[] row, Player player) {
        return Arrays.stream(row).allMatch(square -> boardMap.get(square) == player);
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
        return Arrays.stream(Square.values()).allMatch(square -> boardMap.containsKey(square));
    }

    public Player getSquareValue(Square square) {
        if (boardMap.containsKey(square)) return boardMap.get(square);
        return null;
    }

    private boolean isAnyWinningRow(Player player) {
        return Arrays.stream(Row.all).anyMatch(row -> isWinningRow(row, player));
    }
}