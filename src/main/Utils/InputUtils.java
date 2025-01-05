package main.Utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void setScanner(Scanner scanner) {
        InputUtils.scanner = scanner;
    }

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
            String card = getString().trim();
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
                        System.out.println("Invalid Selection.");
                        break;
                }
            }
        }
    }

    public static void awaitInput() {
        System.out.println("Press enter to continue.\n");

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
            if (input < 1 || input > 6) {
                System.out.println("Invalid number of players. Please enter a number between 1 and 6:");
            } else {
                return input;
            }
        }
    }

    public static int getNumBots(int maxBots) {
        while (true) {
            int input = getInt();
            if (input < 1 || input > maxBots) {
                System.out.printf("Invalid number of bots. Please enter a number between 1 and %d:\n", maxBots);
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

    public static int getBotDifficulty() {
        while (true) {
            int input = getInt();
            if (input <= 0 || input > 2) {
                System.out.println("Please select either Easy (1) or Normal (2)");
            } else {
                return input;
            }
        }
    }

    public static boolean getBotsPlaying() {
        while (true) {
            String input = getString().toLowerCase();
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

    public static boolean getContinuePlaying() {
        System.out.println("Would you like to restart? (y/n)");
        while (true) {
            String input = getString().toLowerCase();
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
