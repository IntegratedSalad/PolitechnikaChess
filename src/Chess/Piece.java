package Chess;

public interface Piece {

    public boolean DoMove(final Piece[][] mapArray);

    /* Getters */
    public Color GetColor();
    public Pos GetPos();
}
