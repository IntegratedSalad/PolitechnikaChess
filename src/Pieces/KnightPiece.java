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

    public boolean DoMove(final Piece[][] mapArray) {
        return true;
    }
    public String RepresentOnBoard() {
        char colorGlyph;
        if (this.color == Color.BLACK) {
            colorGlyph = 'b';
        } else {
            colorGlyph = 'w';
        }
        return String.valueOf(colorGlyph + glyph);
    }

    /* Getters */
    public Color GetColor() {
        return this.color;
    }
    public Pos GetPos() {
        return this.pos;
    }
}
