package Chess;

import java.util.Scanner;

public class Game {

    private static int currentPlayer;  // index of playerNames
    private static State state;
    private static Player[] players = new Player[2];
    private static Scanner scanner = new Scanner(System.in);

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

        int currentPlayer = GetIntFromInput(false);

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
        Map map = new Map();
        map.PrintMap();

//        while (state == Chess.State.RUNNING) {
//
//        }

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

//    private static int MapPlayerNameToIndex(final String playerName) {
//        int toReturn;
//        if (playerNames[0].equals(playerName)) {
//            toReturn = 0;
//        } else {
//            toReturn = 1;
//        }
//        return toReturn;
//    }

    private static void Reset() {
        System.out.println("Dodobunppo");
    }

    private static void PresentResult() {

    }

    private static void Exit() {

    }

    private static void SetStartingPlayer() {

    }

    private static void AdvancePlayer() {
        if (currentPlayer == 0)
        {
            currentPlayer = 1;
        } else
        {
            currentPlayer = 0;
        }
    }

    private static boolean CheckWin() {
        return false;
    }
}
