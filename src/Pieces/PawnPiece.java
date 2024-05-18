package Pieces;
import Chess.Color;
import Chess.Piece;
import Chess.Pos;

public class PawnPiece implements Piece {

    /* Attributes */
    private Color color = null;
    private Pos pos = null;
    private final String name = "Pawn";
    private final char glyph = 'p';

    public PawnPiece(Color color, Pos pos) {
        this.color = color;
        this.pos = pos;
    }

    public boolean DoMove(final Piece[][] mapArray, final Pos displacementPos) {
        System.out.println("Pawn here :D gan I mobes...");

        final int pieceX = pos.GetX();
        final int pieceY = pos.GetY();
        final int dispX = displacementPos.GetX();
        final int dispY = displacementPos.GetY();

        System.out.println("pieceX: " + pieceX + " pieceY: " + pieceY);
        System.out.println("dispX: " + dispX + " dispY: " + dispY);
        if (this.color == Color.BLACK) { // BLACK
            // From top to bottom
            if (((dispY - pieceY == 1) || (dispY - pieceY == 2)) && (dispX - pieceX == 0)) {
                System.out.println("Legal move!");
                System.out.println("Moved by: " + (dispY - pieceY));
            } else if (((dispY - pieceY == 1) && (dispX - pieceX == 1)) ||
                        (dispY - pieceY == 1) && (dispX - pieceX == -1)) { // taking over a piece
                System.out.println("Legal move!");
                System.out.println("Moved by: Y:" + (dispY - pieceY));
                System.out.println("Moved by: X:" + (dispX - pieceX));
            }

        } else { // WHITE
            // From bottom to top

        }

        return true;
    }
    public String RepresentOnBoard() {
        char colorGlyph;
        if (this.color == Color.BLACK) {
            colorGlyph = 'b';
        } else {
            colorGlyph = 'w';
        }
        return String.valueOf(colorGlyph) + String.valueOf(this.glyph);
    }

    /* Setters */
    public void SetPos(Pos p) {
        this.pos = p;
    }

    public void SetColor(Color c) {
        this.color = c;
    }

    /* Getters */
    public Color GetColor() {
        return this.color;
    }

    public Pos GetPos() {
        return this.pos;
    }

    public String GetName() {
        return this.name;
    }
}
