package main.Utils;

import main.Game.GameLogic;
import main.Game.Player;

public class OutputUtils {

    public static void printTitle() {
        System.out.println(title);
    }

    public static void printGameBar(int gameNumber) {
        try {
            if (gameNumber <= 0) {
                throw new IllegalArgumentException("Invalid game number");
            }
            String text = String.format("Game %d", gameNumber);

            int totalBarLength = 30;

            int textLength = text.length();
            int sideLength = (totalBarLength - textLength - 2) / 2;

            String border = "#".repeat(totalBarLength);
            String leftSide = "#".repeat(Math.max(0, sideLength));
            String rightSide = "#".repeat(Math.max(0, totalBarLength - leftSide.length() - textLength - 2));


            System.out.printf("%s\n%s %s %s\n%s\n\n", border, leftSide, text, rightSide, border);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printRoundBar(int roundNumber) {
        try {
            if (roundNumber <= 0) {
                throw new IllegalArgumentException("Invalid round number");
            }
            String text = String.format("Round %d", roundNumber);

            int totalBarLength = 20;

            int textLength = text.length();
            int sideLength = (totalBarLength - textLength - 2) / 2;

            String leftSide = "-".repeat(Math.max(0, sideLength));
            String rightSide = "-".repeat(Math.max(0, totalBarLength - leftSide.length() - textLength - 2));

            System.out.printf("%s %s %s\n", leftSide, text, rightSide);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printPlayerBar(String playerName) {
        try {
            if(playerName.isEmpty()) {
                throw new IllegalArgumentException("Invalid player name");
            }
            System.out.printf("%s's turn\n\n", playerName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printCurrentHand(String val, boolean redraw) {
        try {
            if(val.isEmpty()) {
                throw new IllegalArgumentException("Hand cannot be empty");
            }
            if (redraw) {
                System.out.printf("Your new hand:\n%s\n", val);
            } else {
                System.out.printf("Your current hand:\n%s\n", val);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printComputerHand(String val, String compName, boolean redraw) {
        try {
            if(val.isEmpty()) {
                throw new IllegalArgumentException("Hand cannot be empty");
            }
            if (compName.isEmpty()) {
                compName = "Computer";
            }
            if (redraw) {
                System.out.printf("%s's new hand:\n%s\n", compName, val);
            } else {
                System.out.printf("%s's current hand:\n%s\n", compName, val);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printTotalsPerSuit(int[] vals) {
        try {
            if(vals.length == 0) {
                throw new IllegalArgumentException("Invalid values provided");
            }
            System.out.println("\nCard totals:");
            for (int i = 0; i < vals.length; i++) {
                System.out.printf("%s: %d\n", GameLogic.suits[i], vals[i]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void congratulateWinners(Player[] winners)
    {
        try {

            if (winners.length == 0) {
                throw new IllegalArgumentException("Invalid input provided");
            }
            String[] names = new String[winners.length];
            for (int i = 0; i < winners.length; i++) {
                names[i] = winners[i].getName();
            }

            if (winners.length > 1) {
                System.out.println("Congratulations! You have won the game!\nWinners:");
                for (String n : names) {
                    System.out.printf("%s\n", n);
                }
            } else {
                System.out.printf("Congratulations! You have won the game!\nWinner: %s\n\n", names[0]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printLeaderboard(Player[] players) {
        try {
            if(players.length == 0) {
                throw new IllegalArgumentException("Invalid input provided");
            }
            String leaderBoard = "Results:";

            for (int i = 0; i < players.length; i++) {
                leaderBoard = String.format("%s\n%d: %s - %.2f point(s)", leaderBoard, i + 1, players[i].getName(), players[i].getScore());
            }
            System.out.println(leaderBoard);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
