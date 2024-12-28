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
            if(input.isEmpty()) {
                System.out.println("You cannot leave the player name blank. Please try again:");
            }
            else {
                return input;
            }
        }
    }

    private static int getInt() {
        while (true) {
            try {
                return Integer.parseInt(getString());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number:");
            }
        }
    }

    public static int getNumPlayers() {
        while (true) {
            int input = getInt();
            if(input <= 1 || input > 6){
                System.out.println("Invalid number of players. Please enter a number between 2 and 6:");
            }
            else {
                return input;
            }
        }
    }

    public static int getNumRounds() {
        while (true) {
            int input = getInt();
            if(input <= 0) {
                System.out.println("Invalid number of rounds. Please enter a number greater than 0:");
            }
            else {
                return input;
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
    }

}
