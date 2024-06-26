package Chess;
import java.util.Scanner;

public class Game {

    private static int currentPlayer;  // index of playerNames
    private static State state;
    private static Player[] players = new Player[2];
    private static final Scanner scanner = new Scanner(System.in);
    private static Map map;

    private static final int RETURN_ERROR = 65535;

    public Game() {
        state = State.RUNNING;
    }

    public State Run() {
        System.out.println("Welcome to the chess gaem :DD");

        Player p1 = new Player();
        Player p2 = new Player();

        System.out.println("Player1 name:");
        String player1Name = GetInput(false);
        p1.SetName(player1Name);

        System.out.println("Player2 name:");
        String player2Name = GetInput(false);
        p2.SetName(player2Name);

        // Decide which player starts
        System.out.println("Which player starts? (1 or 2)");
        System.out.println("Player (1): " + p1.GetName());
        System.out.println("Player (2): " + p2.GetName());

        currentPlayer = GetIntFromInput(false);

        if (currentPlayer <= 2 && currentPlayer >= 1) {
            currentPlayer -= 1;
        } else {
            return State.ERROR;
        }

        players[0] = p1;
        players[1] = p2;

        players[currentPlayer].SetColor(Color.WHITE);

        if (currentPlayer == 1) {
            players[0].SetColor(Color.BLACK);
        } else
        {
            players[1].SetColor(Color.BLACK);
        }

        System.out.println(players[currentPlayer].GetName() +
                          " starts (" + players[currentPlayer].GetColor() + ")");
        System.out.println("Starting game");

        // Setup Board
        map = new Map();
        System.out.println("Enter piece position and what place to move it to:");
        System.out.println("Input row first ex.: a1 c6");
        while (state == Chess.State.RUNNING) {
            map.PrintMap();
            System.out.print("(" + players[currentPlayer].GetName() + ", " + players[currentPlayer].GetColor() + ") >> ");
            String input = GetInput(false);
            System.out.println();

            if (input.equals("exit") || input.equals("quit") || input.equals("q") || input.equals("e")) {
                state = State.EXIT;
                return State.EXIT;
            }

            if (ProcessPlayerTurn(players[currentPlayer], input)) { // only if valid turn result, advance the player
                AdvancePlayer();
            }
            // TODO: Check if win
        }

        state = State.EXIT;
        return state;
    }

    private static String GetInput(boolean echo) {
        String inputLine = scanner.nextLine();

        while (inputLine.isEmpty()) {
            System.out.println("Try again:");
            inputLine = scanner.nextLine();
        }

        if (echo) {
            System.out.println("Echo: " + inputLine);
        }
        return inputLine;
    }

    private static int GetIntFromInput(boolean echo) {
        final String input = GetInput(echo);
        int x;
        try {
            x = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("You have to type a number");
            x = RETURN_ERROR;
        }
        return x;
    }

    private static boolean ProcessPlayerTurn(Player currentPlayer, final String input) {
        Pos[] inputPosArr = map.ResolvePosFromInput(input);
        if (inputPosArr == null) {
            System.out.println("Invalid input!");
            return false;
        }

        if (!(inputPosArr[0].Validate() && inputPosArr[1].Validate())) {
            System.out.println("You have entered an invalid position");
            return false;
        }

        System.out.println(currentPlayer.GetName() +  " (" + currentPlayer.GetColor()  + ") " + "turn: ");

        System.out.println("Piece pos: ");
        inputPosArr[0].PrintPos();
        System.out.println("Displacement pos: ");
        inputPosArr[1].PrintPos();

        return map.MovePiece(currentPlayer, inputPosArr[0], inputPosArr[1]);
    }

    private static void Reset() {
    }

    private static void PresentResult() {

    }

    private static void Exit() {

    }

    private static void AdvancePlayer() {
        if (Game.currentPlayer == 0)
        {
            Game.currentPlayer = 1;
        } else
        {
            Game.currentPlayer = 0;
        }
    }

    private static boolean CheckWin() {
        return map.CheckWin();
    }
}
