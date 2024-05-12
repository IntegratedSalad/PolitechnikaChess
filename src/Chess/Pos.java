package Chess;
public class Pos {
    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void SetX(int _x) {
        this.x = _x;
    }

    public void SetY(int _y) {
        this.y = _y;
    }

    public int GetX() {
        return this.x;
    }

    public int GetY() {
        return this.y;
    }
}
