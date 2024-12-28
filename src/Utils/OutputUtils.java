package Utils;

import Game.GameLogic;
import Game.Player;

public class OutputUtils {

    public static void printTitle() {
        System.out.println(title);
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
        System.out.printf("\n\n%s's turn\n\n", playerName);
    }

    public static void printCurrentHand(String val, boolean redraw) {
        if (redraw) {
            System.out.printf("Your new hand: \n%s\n", val);
        } else {
            System.out.printf("Your current hand: \n%s\n", val);
        }
    }

    public static void printTotalsPerSuit(int[] vals) {
        System.out.println("\nCard totals:");
        for(int i = 0; i < vals.length; i++) {
            System.out.printf("%s: %d\n", GameLogic.suits[i], vals[i]);
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
