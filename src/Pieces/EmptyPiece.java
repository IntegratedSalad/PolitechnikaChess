package Pieces;
import Chess.Color;
import Chess.Piece;
import Chess.Pos;

public class EmptyPiece implements Piece {
    /* Attributes */
    private Color color = null;
    private Pos pos = null;

    public EmptyPiece(int x, int y) {
        Pos pos = new Pos(x, y);
        this.SetPos(pos);
    }

    /* Methods */
    public boolean DoMove(final Piece[][] mapArray) {
        System.out.println("Attempted to move Empty Piece");
        return false;
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
        return null;
    }

    public Pos GetPos() {
        return this.pos;
    }
}