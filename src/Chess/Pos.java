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

    public void PrintPos() {
        System.out.println("X: " + this.x + " Y: " + this.y);
    }

    public boolean Validate() {
        // It's 1 because player physically will input 1 or 8.
        return (this.x >= 1 && this.x <= 8 && this.y >= 1 && this.y <= 8);
    }
}
