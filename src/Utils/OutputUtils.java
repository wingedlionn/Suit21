package Utils;

import Game.GameLogic;
import Game.Player;

public class OutputUtils {

    public static void printTitle() {
        System.out.println(title);
    }

    public static void printGameBar(int gameNumber) {
        String text = String.format("Game %d", gameNumber);

        int totalBarLength = 30;

        int textLength = text.length();
        int sideLength = (totalBarLength - textLength - 2) / 2;

        String border = "#".repeat(Math.max(0, totalBarLength));
        String leftSide = "#".repeat(Math.max(0, sideLength));
        String rightSide = "#".repeat(Math.max(0, totalBarLength - leftSide.length() - textLength - 2));


        System.out.printf("%s\n%s %s %s\n%s\n\n", border, leftSide, text, rightSide, border);
    }

    public static void printRoundBar(int roundNumber) {
        String text = String.format("Round %d", roundNumber);

        int totalBarLength = 20;

        int textLength = text.length();
        int sideLength = (totalBarLength - textLength - 2) / 2;

        String leftSide = "-".repeat(Math.max(0, sideLength));
        String rightSide = "-".repeat(Math.max(0, totalBarLength - leftSide.length() - textLength - 2));

        System.out.printf("%s %s %s", leftSide, text, rightSide);
    }

    public static void printPlayerBar(String playerName) {
        System.out.printf("%s's turn\n\n", playerName);
    }

    public static void printCurrentHand(String val, boolean redraw) {
        if (redraw) {
            System.out.printf("Your new hand: \n%s\n", val);
        } else {
            System.out.printf("Your current hand: \n%s\n", val);
        }
    }

    public static void printComputerHand(String val, String compName, boolean redraw) {
        if (redraw) {
            System.out.printf("%s's new hand: \n%s\n", compName, val);
        } else {
            System.out.printf("%s's current hand: \n%s\n", compName, val);
        }
    }

    public static void printTotalsPerSuit(int[] vals) {
        System.out.println("\nCard totals:");
        for(int i = 0; i < vals.length; i++) {
            System.out.printf("%s: %d\n", GameLogic.suits[i], vals[i]);
        }
    }

    public static void congratulateWinners(Player[] winners)
    {
        String[] names = new String[winners.length];
        for(int i = 0; i < winners.length; i++) {
            names[i] = winners[i].getName();
        }

        if(winners.length > 1) {
            System.out.println("Congratulations! You have won the game!\nWinners:\n\n");
            for(String n : names) {
                System.out.printf("%s\n", n);
            }
        }
        else {
            System.out.printf("Congratulations! You have won the game!\nWinner: %s\n\n", names[0]);
        }
    }

    public static void printLeaderboard(Player[] players) {
        String leaderBoard = "Results:";

        for (int i = 0; i < players.length; i++) {
            leaderBoard = String.format("%s\n%d: %s - %.2f point(s)", leaderBoard, i+1, players[i].getName(), players[i].getScore());
        }
        System.out.println(leaderBoard);
        System.out.println("Congratulations!");
    }


    private static final String title =
            """
                     ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄     ▄▄▄▄    \s
                    ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌  ▄█░░░░▌   \s
                    ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌ ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌ ▐░░▌▐░░▌   \s
                    ▐░▌          ▐░▌       ▐░▌     ▐░▌          ▐░▌                    ▐░▌  ▀▀ ▐░░▌   \s
                    ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌     ▐░▌          ▐░▌                    ▐░▌     ▐░░▌   \s
                    ▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌          ▐░▌           ▄▄▄▄▄▄▄▄▄█░▌     ▐░░▌   \s
                     ▀▀▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌     ▐░▌          ▐░▌          ▐░░░░░░░░░░░▌     ▐░░▌   \s
                              ▐░▌▐░▌       ▐░▌     ▐░▌          ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀      ▐░░▌   \s
                     ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄█░█▄▄▄▄      ▐░▌          ▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░░█▄▄▄\s
                    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                     ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                      \s""";
}
