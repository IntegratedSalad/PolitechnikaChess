package Chess;
import Pieces.EmptyPiece;

public class Map {

    private static final int BOARD_SIZE_WIDTH = 8;
    private static final int BOARD_SIZE_HEIGHT = 8;

    private Piece[][] mapArray;

    public Map() {
        mapArray = new Piece[BOARD_SIZE_WIDTH][BOARD_SIZE_HEIGHT];

        for (int y = 0; y < BOARD_SIZE_HEIGHT; y++) {
            for (int x = 0; x < BOARD_SIZE_WIDTH; x++) {
                Piece emptyPiece = new EmptyPiece(x, y);
                mapArray[y][x] = emptyPiece;
                // x span from a to h
                // y span from 8 to 1
            }
        }
    }

    public Piece[][] GetMapArray() {
        return mapArray;
    }

    public void PrintMap() {

        final String rowMarks = "abcdefgh";
        for (int y = 0; y < BOARD_SIZE_HEIGHT + 1; y++) {
            for (int x = 0; x < BOARD_SIZE_WIDTH + 1; x++) {
                if (y == 0)
                {
                    System.out.print(rowMarks.charAt(x));
                }



                if (x == BOARD_SIZE_WIDTH)
                {
                    System.out.print(8 - y);
                }
            }
            System.out.println();
        }
    }

    public Pos ResolvePosFromInput(final String input) {
        // TODO: Important
        Pos pos = new Pos(0, 0);
        // here?

        return pos;
    }
}
