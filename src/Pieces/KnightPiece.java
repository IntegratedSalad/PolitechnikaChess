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

        // Calculate the differences in x and y positions
        int deltaX = Math.abs(dispX - pieceX);
        int deltaY = Math.abs(dispY - pieceY);

        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
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
