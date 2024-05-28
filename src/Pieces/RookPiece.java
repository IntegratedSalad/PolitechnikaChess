package Pieces;

import Chess.Color;
import Chess.Piece;
import Chess.Pos;

import static java.lang.Math.abs;

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

    public boolean DoMove(final Piece[][] mapArray, final Pos displacementPos) {
        System.out.println("Movinge rooke :DDDD");
        final int pieceX = pos.GetX();
        final int pieceY = pos.GetY();
        final int dispX = displacementPos.GetX();
        final int dispY = displacementPos.GetY();

        int dirX = 0;
        int dirY = 0;
        
        if (dispX - pieceX != 0)
            dirX = (dispX - pieceX) / abs(dispX - pieceX);
        if (dispY - pieceY != 0)
            dirY = (dispY - pieceY) / abs(dispY - pieceY);

        System.out.println("pieceX: " + pieceX + " pieceY:" + pieceY);
        System.out.println("dispX: " + dispX + " dispY:" + dispY);
        System.out.println("dirX: " + dirX + " dirY:" + dirY);

        if (((dirX == 1 && dirY == 0) || (dirX == -1 && dirY == 0)) ||
                (dirX == 0 && dirY == 1) || (dirX == 0 && dirY == -1)) {
            int x = pieceX + dirX;
            int y = pieceY + dirY;
            while (x != dispX || y != dispY) { // when horizontal/vertical, one of the dirs is 0!
                if (!(mapArray[y][x] instanceof EmptyPiece)) {
                    System.out.println("Something's in the way...");
                    return false;
                }
                x += dirX;
                y += dirY;
            }
            return true;
        }
        return false;
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
