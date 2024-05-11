import java.util.Scanner;

public class Game {

    private static int currentPlayer;  // index of playerNames
    private static State state;
    private static String[] playerNames = new String[2];
    private static Scanner scanner = new Scanner(System.in);

    public Game() {
        state = State.RUNNING;
    }

    public State Run() {
        System.out.println("Welcome to the chess gaem :DD");

        System.out.println("Player1 name:");
        String player1Name = GetInput(false);
        playerNames[0] = player1Name;

        System.out.println("Player2 name:");
        String player2Name = GetInput(false);
        playerNames[1] = player2Name;

        // Decide which player starts
        System.out.println("Which player starts? (1 or 2)");
        System.out.println("Player (1): " + playerNames[0]);
        System.out.println("Player (2): " + playerNames[1]);
        int currentPlayer = GetIntFromInput(false);

        if (currentPlayer != 65535) {
            currentPlayer -= 1;
        } else {
            state = State.ERROR;
            return state;
        }
        System.out.println("Current player = " + currentPlayer);

        System.out.println("Starting game");
//        while (state == State.RUNNING) {
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
            System.out.println("Please enter a number, try again");
            x = 65535;
        }
        return x;
    }

    private static int MapPlayerNameToIndex(final String playerName) {
        int toReturn;
        if (playerNames[0].equals(playerName)) {
            toReturn = 0;
        } else {
            toReturn = 1;
        }
        return toReturn;
    }

    private static void Reset() {
        System.out.println("Dodobunppo");
    }

    private static void PresentResult() {

    }

    private static void Exit() {

    }

    private static void SetStartingPlayer() {

    }

    private static boolean CheckWin() {
        return false;
    }
}
