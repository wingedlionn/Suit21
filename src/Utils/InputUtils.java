package Utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private static String getString() {
        return scanner.nextLine();
    }

    public static String getPlayerName() {
        while (true) {
            String input = getString();
            if (input.isEmpty()) {
                System.out.println("You cannot leave the player name blank. Please try again:");
            } else {
                return input;
            }
        }
    }

    public static String getCardSwap() {
        System.out.println("Which card would you like to swap? (A, B, C, D, E)");
        while (true) {
            String card = getString();
            if (card.isEmpty()) {
                System.out.println("You must select a card.");
            } else {
                switch (card.toUpperCase()) {
                    case "A":
                        return "A";
                    case "B":
                        return "B";
                    case "C":
                        return "C";
                    case "D":
                        return "D";
                    case "E":
                        return "E";
                    default:
                        System.out.println("You must select a card.");
                        break;
                }
            }
        }
    }

    public static void awaitInput(boolean message) {

        if (message) {
            System.out.println("Press enter to continue.");
        }
        String in = getString();
        if (in.isEmpty()) {
            return;
        }
    }

    private static int getInt() {
        while (true) {
            try {
                return Integer.parseInt(getString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number:");
            }
        }
    }

    public static int getNumPlayers() {
        while (true) {
            int input = getInt();
            if (input <= 1 || input > 6) {
                System.out.println("Invalid number of players. Please enter a number between 2 and 6:");
            } else {
                return input;
            }
        }
    }

    public static int getNumGames() {
        while (true) {
            int input = getInt();
            if (input <= 0) {
                System.out.println("Invalid number of games. Please enter a number greater than 0:");
            } else {
                return input;
            }
        }
    }

    public static boolean getContinuePlaying() {
        System.out.println("Would you like to restart? (y/n)");
        while (true) {
            String input = getString();
            if (input.equals("y")) {
                return true;
            }
            if (input.equals("n")) {
                return false;
            } else {
                System.out.println("You must select yes (y) or no (n). Please try again.");
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
    }

}
