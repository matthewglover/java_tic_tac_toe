package com.matthewglover.tictactoe;

public class Row {
    public static Move[] top = {Move.TL, Move.TM, Move.TR};
    public static Move[] horizontalMiddle = {Move.ML, Move.MM, Move.MR};
    public static Move[] bottom = {Move.BL, Move.BM, Move.BR};
    public static Move[] left = {Move.TL, Move.ML, Move.BL};
    public static Move[] verticalMiddle = {Move.TM, Move.MM, Move.BM};
    public static Move[] right = {Move.TR, Move.MR, Move.BR};
}
