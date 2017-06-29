package com.matthewglover.tictactoe;

public class BoardRenderer {
    private Board board;

    public BoardRenderer(Board b) {
        board = b;
    }

    public String[] getRenderLines() {
        String divider = "----- ----- ----";
        String[] rows = {
                buildRow("t", board.getSquareValue(Square.TL), board.getSquareValue(Square.TM), board.getSquareValue(Square.TR)),
                divider,
                buildRow("m", board.getSquareValue(Square.ML), board.getSquareValue(Square.MM), board.getSquareValue(Square.MR)),
                divider,
                buildRow("b", board.getSquareValue(Square.BL), board.getSquareValue(Square.BM), board.getSquareValue(Square.BR))};

        return rows;
    }

    private static String buildRow(String rowPrefix, Player leftValue, Player middleValue, Player rightValue) {
        String leftSquare = renderPlayerOrSquareName(leftValue, rowPrefix + "l");
        String middleSquare = renderPlayerOrSquareName(middleValue, rowPrefix + "m");
        String rightSquare = renderPlayerOrSquareName(rightValue, rowPrefix + "r");
        return String.format(" %s  | %s  | %s", leftSquare, middleSquare, rightSquare);
    }

    private static String renderPlayerOrSquareName(Player player, String squareName) {
        if (player == Player.X) return " X";
        if (player == Player.O) return " O";
        return squareName;
    }
}
