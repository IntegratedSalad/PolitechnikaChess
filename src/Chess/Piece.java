package Chess;

/* Every piece class has to have name, glyph and method to represent */
public interface Piece {

    /* Piece itself doesn't move itself nor anything on the mapArray! */
    /* Every piece's DoMove automatically updates its Pos! */
    public boolean DoMove(final Piece[][] mapArray, final Pos displacementPos);
    public String RepresentOnBoard();

    /* Getters */
    public Color GetColor();
    public Pos GetPos();
    public void SetPos(final Pos pos);
    public void SetColor(final Color color);
    public String GetName();

}
