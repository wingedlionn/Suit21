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
            OutputUtils.printCurrentHand(p.hand.toString(), false);
            OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());
            System.out.println("Would you like to swap a card? (y/n)");
            String selectedCard = InputUtils.getCardSwap();
            if(selectedCard == null) {
                System.out.println("Your hand has remained unchanged.");
            }
            else {
                switch(selectedCard.toUpperCase()) {
                    case "A": p.hand.removeCardAtIndex(0); break;
                    case "B": p.hand.removeCardAtIndex(1); break;
                    case "C": p.hand.removeCardAtIndex(2); break;
                    case "D": p.hand.removeCardAtIndex(3); break;
                    case "E": p.hand.removeCardAtIndex(4); break;
                }
                System.out.printf("You have drawn the %s.\n", deck.cards.getFirst().toString());
                p.hand.add(deck.cards.getFirst());
                deck.cards.removeFirst();
                OutputUtils.printCurrentHand(p.hand.toString(), true);
                OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());
            }

            InputUtils.awaitInput(true);
        }


    }

}
