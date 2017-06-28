package com.matthewglover.tictactoe;

public final class Row {
    public static Square[] top = {Square.TL, Square.TM, Square.TR};
    public static Square[] horizontalMiddle = {Square.ML, Square.MM, Square.MR};
    public static Square[] bottom = {Square.BL, Square.BM, Square.BR};
    public static Square[] left = {Square.TL, Square.ML, Square.BL};
    public static Square[] verticalMiddle = {Square.TM, Square.MM, Square.BM};
    public static Square[] right = {Square.TR, Square.MR, Square.BR};
    public static Square[] diagonalLeftToRight = {Square.TL, Square.MM, Square.BR};
    public static Square[] diagonalRightToLeft = {Square.TR, Square.MM, Square.BL};
    public static Square[][] all = {Row.top, Row.horizontalMiddle, Row.bottom, Row.left, Row.verticalMiddle,
            Row.right, Row.diagonalLeftToRight, Row.diagonalRightToLeft};
}
