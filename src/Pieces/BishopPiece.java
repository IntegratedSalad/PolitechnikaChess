package Pieces;

import Chess.Color;
import Chess.Piece;
import Chess.Pos;

import static java.lang.Math.*;

public class BishopPiece implements Piece {
    /* Attributes */
    private Color color = null;
    private Pos pos = null;
    private final String name = "Bishop";
    private final char glyph = 'B';

    public BishopPiece(Color color, Pos pos) {
        this.color = color;
        this.pos = pos;
    }

    public boolean DoMove(final Piece[][] mapArray, final Pos displacementPos) {
        System.out.println("Movinge binshopee :DDDD");
        final int pieceX = pos.GetX();
        final int pieceY = pos.GetY();
        final int dispX = displacementPos.GetX();
        final int dispY = displacementPos.GetY();
//        final double length = floor(sqrt(pow(dispX - pieceX, 2) + pow(dispY - pieceY, 2)));

        final int dirX = (dispX - pieceX) / abs(dispX - pieceX);
        final int dirY = (dispY - pieceY) / abs(dispY - pieceY);

        System.out.println("pieceX: " + pieceX + " pieceY:" + pieceY);
        System.out.println("dispX: " + dispX + " dispY:" + dispY);
        System.out.println("dirX: " + dirX + " dirY:" + dirY);

        if ((dirX == 1 && dirY == 1) ||
           (dirX == -1 && dirY == -1) ||
           (dirX == 1 && dirY == -1) ||
           (dirX == -1 && dirY == 1)) { // only diagonally
            int x = pieceX;
            int y = pieceY;
            System.out.println("Diagonal move!");
            while (x != dispX && y != dispY) {
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
