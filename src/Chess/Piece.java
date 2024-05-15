package Chess;

/* Every piece class has to have name, glyph and method to represent */
public interface Piece {

    public boolean DoMove(final Piece[][] mapArray, Color color);
    public String RepresentOnBoard();

    /* Getters */
    public Color GetColor();
    public Pos GetPos();
    public String GetName();

}
