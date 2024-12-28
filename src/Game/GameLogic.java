package Game;
import Cards.*;
import Utils.*;

public class GameLogic {
    public static String[] suits;
    public static Player[] players;
    public static int currentRound;

    public static void playGame() {
        Deck deck = new Deck();
        for(Player p : players) {
            p.hand.addHand(deck.dealHand());
        }

        OutputUtils.printRoundBar(1);

        for(Player p : players) {
            OutputUtils.printPlayerBar(p.getName());
            OutputUtils.printCurrentHand(p.hand.toString());
            OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());
        }


    }

}
