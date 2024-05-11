//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        State state = game.Run();

        if (state == State.EXIT) {
            System.out.println("All good.");
        } else if ( state == State.ERROR) {
            System.out.println("Returned with error");
        } else {
            System.out.println("Returned unexpected state");
        }
    }
}