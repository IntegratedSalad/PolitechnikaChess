package Chess;

public class Player {

    private Color color;
    private String name;
    private int score;

    void SetColor(Color color) {
        this.color = color;
    }

    void SetName(String name) {
        this.name = name;
    }

    void SetScore(int score) {
        this.score = score;
    }

    public Color GetColor() {
        return color;
    }

    public String GetName() {
        return name;
    }

    public int GetScore() {
        return score;
    }
}
