package Pieces;

import Chess.Color;
import Chess.Piece;
import Chess.Pos;

public class RookPiece implements Piece {
    /* Attributes */
    private Color color = null;
    private Pos pos = null;
    private final String name = "Rook";
    private final char glyph = 'X';

    public RookPiece(Color color, Pos pos) {
        this.color = color;
        this.pos = pos;
    }

    public boolean DoMove(final Piece[][] mapArray, Color color) {
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
