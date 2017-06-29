package com.matthewglover.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardRendererTest {

    private Board board = new Board();
    private BoardRenderer boardRenderer = new BoardRenderer(board);

    @Test
    public void rendersBlankBoardProperly() {
        String[] expected = {
                " tl  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br"
        };

        assertArrayEquals(expected, boardRenderer.getRenderLines());
    }

    @Test
    public void rendersSingleMoveProperly() throws IllegalMoveException {
        board.move(Square.TL, Player.X);

        String[] expected = {
                "  X  | tm  | tr",
                "----- ----- ----",
                " ml  | mm  | mr",
                "----- ----- ----",
                " bl  | bm  | br"
        };

        assertArrayEquals(expected, boardRenderer.getRenderLines());
    }

    @Test
    public void rendersTwoMovesProperly() throws IllegalMoveException {
        board.move(Square.TL, Player.X);
        board.move(Square.MM, Player.O);

        String[] expected = {
                "  X  | tm  | tr",
                "----- ----- ----",
                " ml  |  O  | mr",
                "----- ----- ----",
                " bl  | bm  | br"
        };

        assertArrayEquals(expected, boardRenderer.getRenderLines());
    }

    @Test
    public void rendersThreeMovesProperly() throws IllegalMoveException {
        board.move(Square.TL, Player.X);
        board.move(Square.MM, Player.O);
        board.move(Square.BR, Player.X);

        String[] expected = {
                "  X  | tm  | tr",
                "----- ----- ----",
                " ml  |  O  | mr",
                "----- ----- ----",
                " bl  | bm  |  X"
        };

        assertArrayEquals(expected, boardRenderer.getRenderLines());
    }

    @Test
    public void rendersCompleteBoardProperly() throws IllegalMoveException {
        board.move(Square.TL, Player.X);
        board.move(Square.TM, Player.O);
        board.move(Square.TR, Player.X);
        board.move(Square.ML, Player.X);
        board.move(Square.MM, Player.X);
        board.move(Square.MR, Player.O);
        board.move(Square.BL, Player.O);
        board.move(Square.BM, Player.X);
        board.move(Square.BR, Player.O);

        String[] expected = {
                "  X  |  O  |  X",
                "----- ----- ----",
                "  X  |  X  |  O",
                "----- ----- ----",
                "  O  |  X  |  O"
        };

        assertArrayEquals(expected, boardRenderer.getRenderLines());
    }
}