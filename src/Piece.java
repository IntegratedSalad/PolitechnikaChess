public interface Piece {
    public Color pieceColor = null;
    public Pos pos = null;

    public boolean DoMove(final Piece[][] mapArray);
    public Color GetColor();
    public Pos GetPos();
}
