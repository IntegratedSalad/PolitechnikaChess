package Pieces;

import Chess.Color;
import Chess.Piece;
import Chess.Pos;

public class KingPiece implements Piece {
    /* Attributes */
    private Color color = null;
    private Pos pos = null;
    private final String name = "King";
    private final char glyph = '&';

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
}
