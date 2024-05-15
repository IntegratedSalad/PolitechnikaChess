package Chess;
import Pieces.*;

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

        mapArray[0][0] = new RookPiece(Color.BLACK, new Pos(0, 0));
        mapArray[0][1] = new KnightPiece(Color.BLACK, new Pos(1, 0));
        mapArray[0][2] = new BishopPiece(Color.BLACK, new Pos(2, 0));
        mapArray[0][3] = new QueenPiece(Color.BLACK, new Pos(3, 0));
        mapArray[0][4] = new KingPiece(Color.BLACK, new Pos(4, 0));
        mapArray[0][5] = new BishopPiece(Color.BLACK, new Pos(5, 0));
        mapArray[0][6] = new KnightPiece(Color.BLACK, new Pos(6, 0));
        mapArray[0][7] = new RookPiece(Color.BLACK, new Pos(7, 0));

        // Maybe method "initialize pawns"
        mapArray[1][0] = new PawnPiece(Color.BLACK, new Pos(0, 1));
        mapArray[1][1] = new PawnPiece(Color.BLACK, new Pos(1, 1));
        mapArray[1][2] = new PawnPiece(Color.BLACK, new Pos(2, 1));
        mapArray[1][3] = new PawnPiece(Color.BLACK, new Pos(3, 1));
        mapArray[1][4] = new PawnPiece(Color.BLACK, new Pos(4, 1));
        mapArray[1][5] = new PawnPiece(Color.BLACK, new Pos(5, 1));
        mapArray[1][6] = new PawnPiece(Color.BLACK, new Pos(6, 1));
        mapArray[1][7] = new PawnPiece(Color.BLACK, new Pos(7, 1));

        // WHITE
        mapArray[7][0] = new RookPiece(Color.WHITE, new Pos(0, 0));
        mapArray[7][1] = new KnightPiece(Color.WHITE, new Pos(1, 0));
        mapArray[7][2] = new BishopPiece(Color.WHITE, new Pos(2, 0));
        mapArray[7][3] = new QueenPiece(Color.WHITE, new Pos(3, 0));
        mapArray[7][4] = new KingPiece(Color.WHITE, new Pos(4, 0));
        mapArray[7][5] = new BishopPiece(Color.WHITE, new Pos(5, 0));
        mapArray[7][6] = new KnightPiece(Color.WHITE, new Pos(6, 0));
        mapArray[7][7] = new RookPiece(Color.WHITE, new Pos(7, 0));

        mapArray[6][0] = new PawnPiece(Color.WHITE, new Pos(0, 1));
        mapArray[6][1] = new PawnPiece(Color.WHITE, new Pos(1, 1));
        mapArray[6][2] = new PawnPiece(Color.WHITE, new Pos(2, 1));
        mapArray[6][3] = new PawnPiece(Color.WHITE, new Pos(3, 1));
        mapArray[6][4] = new PawnPiece(Color.WHITE, new Pos(4, 1));
        mapArray[6][5] = new PawnPiece(Color.WHITE, new Pos(5, 1));
        mapArray[6][6] = new PawnPiece(Color.WHITE, new Pos(6, 1));
        mapArray[6][7] = new PawnPiece(Color.WHITE, new Pos(7, 1));
    }

    public Piece[][] GetMapArray() {
        return mapArray;
    }

    public void PrintMap() {
        final String rowMarks = "abcdefgh";

        System.out.println("Map:");
        for (int y = 0; y < BOARD_SIZE_HEIGHT; y++) {
            System.out.print(rowMarks.charAt(7 - y) + " ");
            for (int x = 0; x < BOARD_SIZE_WIDTH; x++) {
                System.out.print(this.mapArray[y][x].RepresentOnBoard() + " ");
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE_WIDTH; i++) {
            System.out.print(i+1 + "  ");
        }
        System.out.println();
    }

    public Pos ResolvePosFromInput(final String input) {
        // TODO: Important
        Pos pos = new Pos(0, 0);
        // here?

        return pos;
    }
}
