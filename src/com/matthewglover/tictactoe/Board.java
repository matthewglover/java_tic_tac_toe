package com.matthewglover.tictactoe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Move, Player> boardMap = new HashMap<>();

    public boolean isComplete() {
        return hasWonTopRow(Player.X) ||
                hasWonTopRow(Player.O);
    }

    public void move(Move move, Player player) {
        boardMap.put(move, player);
    }

    public boolean hasWonTopRow(Player player) {
        return allMovesTaken(Row.top, player);
    }

    public boolean hasWonHorizontalMiddleRow(Player player) {
        return allMovesTaken(Row.horizontalMiddle, player);
    }

    public boolean hasWonBottomRow(Player player) {
        return allMovesTaken(Row.bottom, player);
    }

    public boolean hasWonLeftRow(Player player) {
        return allMovesTaken(Row.left, player);
    }

    public boolean hasWonVerticalMiddleRow(Player player) {
        return allMovesTaken(Row.verticalMiddle, player);
    }

    public boolean hasWonRightRow(Player player) {
        return allMovesTaken(Row.right, player);
    }

    private boolean allMovesTaken(Move[] moves, Player player) {
        return Arrays.stream(moves).allMatch(move -> boardMap.get(move) == player);
    }
}