package Chess;
import Pieces.*;

public class Map {
    private static final int BOARD_SIZE_WIDTH = 8;
    private static final int BOARD_SIZE_HEIGHT = 8;

    private static boolean isCheck = false;
    private static boolean isMate = false;
    private static Color winningColor = Color.UNDEFINED;

    private Piece[][] mapArray;

    public Map() {
        mapArray = new Piece[BOARD_SIZE_WIDTH][BOARD_SIZE_HEIGHT];

        for (int y = 0; y < BOARD_SIZE_HEIGHT; y++) {
            for (int x = 0; x < BOARD_SIZE_WIDTH; x++) {
                Piece emptyPiece = new EmptyPiece(x, y);
                mapArray[y][x] = emptyPiece;
                // y span from a to h
                // x span from 8 to 1
            }
        }

        // BLACK
        mapArray[0][0] = new RookPiece(Color.BLACK, new Pos(0, 0));
        mapArray[0][1] = new KnightPiece(Color.BLACK, new Pos(1, 0));
        mapArray[0][2] = new BishopPiece(Color.BLACK, new Pos(2, 0));
        mapArray[0][3] = new QueenPiece(Color.BLACK, new Pos(3, 0));
        mapArray[0][4] = new KingPiece(Color.BLACK, new Pos(4, 0));
        mapArray[0][5] = new BishopPiece(Color.BLACK, new Pos(5, 0));
        mapArray[0][6] = new KnightPiece(Color.BLACK, new Pos(6, 0));
        mapArray[0][7] = new RookPiece(Color.BLACK, new Pos(7, 0));

        mapArray[1][0] = new PawnPiece(Color.BLACK, new Pos(0, 1));
        mapArray[1][1] = new PawnPiece(Color.BLACK, new Pos(1, 1));
        mapArray[1][2] = new PawnPiece(Color.BLACK, new Pos(2, 1));
        mapArray[1][3] = new PawnPiece(Color.BLACK, new Pos(3, 1));
        mapArray[1][4] = new PawnPiece(Color.BLACK, new Pos(4, 1));
        mapArray[1][5] = new PawnPiece(Color.BLACK, new Pos(5, 1));
        mapArray[1][6] = new PawnPiece(Color.BLACK, new Pos(6, 1));
        mapArray[1][7] = new PawnPiece(Color.BLACK, new Pos(7, 1));

        // WHITE
        mapArray[7][0] = new RookPiece(Color.WHITE, new Pos(0, 7));
        mapArray[7][1] = new KnightPiece(Color.WHITE, new Pos(1, 7));
        mapArray[7][2] = new BishopPiece(Color.WHITE, new Pos(2, 7));
        mapArray[7][3] = new QueenPiece(Color.WHITE, new Pos(3, 7));
        mapArray[7][4] = new KingPiece(Color.WHITE, new Pos(4, 7));
        mapArray[7][5] = new BishopPiece(Color.WHITE, new Pos(5, 7));
        mapArray[7][6] = new KnightPiece(Color.WHITE, new Pos(6, 7));
        mapArray[7][7] = new RookPiece(Color.WHITE, new Pos(7, 7));

        mapArray[6][0] = new PawnPiece(Color.WHITE, new Pos(0, 6));
        mapArray[6][1] = new PawnPiece(Color.WHITE, new Pos(1, 6));
        mapArray[6][2] = new PawnPiece(Color.WHITE, new Pos(2, 6));
        mapArray[6][3] = new PawnPiece(Color.WHITE, new Pos(3, 6));
        mapArray[6][4] = new PawnPiece(Color.WHITE, new Pos(4, 6));
        mapArray[6][5] = new PawnPiece(Color.WHITE, new Pos(5, 6));
        mapArray[6][6] = new PawnPiece(Color.WHITE, new Pos(6, 6));
        mapArray[6][7] = new PawnPiece(Color.WHITE, new Pos(7, 6));
    }

    public Piece[][] GetMapArray() {
        return mapArray;
    }

    public void PrintMap() {
        final String rowMarks = "abcdefgh";

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

    public Pos[] ResolvePosFromInput(final String input) {

        // TODO: check if numerical and alphanumerical in correct places! (compare pos if we can parse char at pos)

        if (input.length() != 5) {
            return null;
        }

        final String rowMarks = "abcdefgh";
        Pos piecePos = new Pos(0, 0);
        Pos pieceDisplacement = new Pos(0, 0);
        Pos[] posArray = new Pos[2];

        final String pieceInputRow = String.valueOf(input.charAt(0)); // Y
        final String pieceInputColumn = String.valueOf(input.charAt(1)); // X
        piecePos.SetY(8 - rowMarks.indexOf(pieceInputRow));
        piecePos.SetX(Integer.parseInt(pieceInputColumn));

        final String inputDisplacementRow = String.valueOf(input.charAt(3)); // Y
        final String inputDisplacementColumn = String.valueOf(input.charAt(4)); // X
        pieceDisplacement.SetY(8 - rowMarks.indexOf(inputDisplacementRow));
        pieceDisplacement.SetX(Integer.parseInt(inputDisplacementColumn));

        piecePos.PrintPos();
        pieceDisplacement.PrintPos();

        posArray[0] = piecePos;
        posArray[1] = pieceDisplacement;

        return posArray;
    }

    public boolean MovePiece(final Player currentPlayer, final Pos piecePos, final Pos dispPos) {
        /* This is done because of how player can input places  */
        piecePos.SetX(piecePos.GetX() - 1);
        piecePos.SetY(piecePos.GetY() - 1);
        dispPos.SetX(dispPos.GetX() - 1);
        dispPos.SetY(dispPos.GetY() - 1);
        System.out.print("Piece at: ");
        System.out.println(piecePos.GetX() + " " + piecePos.GetY() + ":");
        System.out.println(mapArray[piecePos.GetY()][piecePos.GetX()].GetName());
        System.out.println(mapArray[piecePos.GetY()][piecePos.GetX()].GetColor());
        Piece pieceAtPos = mapArray[piecePos.GetY()][piecePos.GetX()];

        if (currentPlayer.GetColor() != pieceAtPos.GetColor()) {
            System.out.println("Cannot move other player's pieces...");
            return false;
        } else if (pieceAtPos instanceof EmptyPiece) {
            System.out.println("Cannot move empty space...");
            return false;
        }

        // Try to teleport the piece there after piece's "DoMove()"
        Piece pieceToMove = mapArray[piecePos.GetY()][piecePos.GetX()];
        boolean canMove = pieceToMove.DoMove(mapArray, dispPos);

        // If true -> look if there's a piece - if it is, delete it and replace
        if (canMove) {
            final int oldPX = piecePos.GetX();
            final int oldPY = piecePos.GetY();
            if (mapArray[dispPos.GetY()][dispPos.GetX()] instanceof EmptyPiece) {
                System.out.println("Empty piece, we can place something here");

                mapArray[oldPY][oldPX] = new EmptyPiece(oldPX, oldPY);
                mapArray[dispPos.GetY()][dispPos.GetX()] = pieceToMove;
                pieceToMove.SetPos(dispPos);
            } else {
                // TODO: Taking over the pieces
                if (mapArray[dispPos.GetY()][dispPos.GetX()].GetColor() != currentPlayer.GetColor()) {
                    System.out.println(mapArray[dispPos.GetY()][dispPos.GetX()].GetName() + " here!\nTaking over!");
                    mapArray[oldPY][oldPX] = new EmptyPiece(oldPX, oldPY);
                    mapArray[dispPos.GetY()][dispPos.GetX()] = pieceToMove;
                    pieceToMove.SetPos(dispPos);
                } else {
                    System.out.println("Cannot take over your own pieces!");
                    canMove = false;
                }
            }
        }
        return canMove;
    }

    public boolean CheckWin() {

        // TODO: Do check
        // TODO: set winning color

        return isCheck && isMate && winningColor != Color.UNDEFINED;
    }
}
