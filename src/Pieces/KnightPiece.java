package Pieces;
import Chess.Color;
import Chess.Piece;
import Chess.Pos;

public class KnightPiece implements Piece {
    /* Attributes */
    private Color color = null;
    private Pos pos = null;
    private final String name = "Knight";
    private final char glyph = 'K';

    public KnightPiece(Color color, Pos pos) {
        this.color = color;
        this.pos = pos;
    }

    public boolean DoMove(final Piece[][] mapArray, final Pos displacementPos) {
        final int pieceX = pos.GetX();
        final int pieceY = pos.GetY();
        final int dispX = displacementPos.GetX();
        final int dispY = displacementPos.GetY();

        if (this.color == Color.BLACK) { // BLACK
            return ((dispX - pieceX == 1) && (dispY - pieceY == 2)) ||
                    (dispX - pieceX == -1) && (dispY - pieceY == 2);
        } else { // WHITE
            return ((dispX - pieceX == 1) && (dispY - pieceY == -2)) ||
                    (dispX - pieceX == -1) && (dispY - pieceY == 2);
        }
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
    public void SetPos(final Pos p) {
        this.pos = p;
    }

    public void SetColor(final Color c) {
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
