package Pieces;

import Chess.Color;
import Chess.Piece;
import Chess.Pos;

import static java.lang.Math.abs;

public class QueenPiece implements Piece {
    /* Attributes */
    private Color color = null;
    private Pos pos = null;
    private final String name = "Queen";
    private final char glyph = 'Q';

    public QueenPiece(Color color, Pos pos) {
        this.color = color;
        this.pos = pos;
    }

    public boolean DoMove(final Piece[][] mapArray, final Pos displacementPos) {

        final int pieceX = pos.GetX();
        final int pieceY = pos.GetY();
        final int dispX = displacementPos.GetX();
        final int dispY = displacementPos.GetY();

        final int deltaX = dispX - pieceX;
        final int deltaY = dispY - pieceY;

        if (!(deltaX == 0 || deltaY == 0 || Math.abs(deltaX) == Math.abs(deltaY))) { // ma byc tyle samo w x i tyle samo w y
            return false;
        }

        final int dirX = deltaX != 0 ? deltaX / Math.abs(deltaX) : 0;
        final int dirY = deltaY != 0 ? deltaY / Math.abs(deltaY) : 0;

        int x = pieceX + dirX;
        int y = pieceY + dirY;

        while (x != dispX || y != dispY) {
            if (!(mapArray[y][x] instanceof EmptyPiece)) {
                System.out.println("Something's in the way...");
                return false;
            }
            x += dirX;
            y += dirY;
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
