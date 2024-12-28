package Game;
import Cards.*;
import Utils.*;

public class GameLogic {
    public static String[] suits;
    public static Player[] players;
    public static int numberOfGames;
    public static int currentGame = 1;
    public static int currentRound;

    public static void playGame() {
        for (int i = 0; i < numberOfGames; i++) {
            OutputUtils.printGameBar(currentGame);
            Deck deck = new Deck();
            boolean winConditionMet = false;
            int numWinners = 0;
            for (Player p : players) {
                p.hand.addHand(deck.dealHand());
            }

            int currentRound = 1;
            do {
                OutputUtils.printRoundBar(currentRound);

                for (Player p : players) {
                    OutputUtils.printPlayerBar(p.getName());
                    OutputUtils.printCurrentHand(p.hand.toString(), false);
                    OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());
                    if (!checkWinCondition(p)) {
                        System.out.println("Would you like to swap a card? (y/n)");
                        String selectedCard = InputUtils.getCardSwap();
                        if (selectedCard == null) {
                            System.out.println("Your hand has remained unchanged.");
                        } else {
                            switch (selectedCard.toUpperCase()) {
                                case "A":
                                    p.hand.removeCardAtIndex(0);
                                    break;
                                case "B":
                                    p.hand.removeCardAtIndex(1);
                                    break;
                                case "C":
                                    p.hand.removeCardAtIndex(2);
                                    break;
                                case "D":
                                    p.hand.removeCardAtIndex(3);
                                    break;
                                case "E":
                                    p.hand.removeCardAtIndex(4);
                                    break;
                            }
                            System.out.printf("You have drawn the %s.\n", deck.cards.getFirst().toString());
                            p.hand.add(deck.cards.getFirst());
                            deck.cards.removeFirst();
                            OutputUtils.printCurrentHand(p.hand.toString(), true);
                            OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());
                        }
                    }

                    if (checkWinCondition(p)) {
                        p.has21 = true;
                        winConditionMet = true;
                        numWinners++;
                    }

                    InputUtils.awaitInput(true);
                }
                currentRound++;
            } while (!winConditionMet && deck.cards.size() >= players.length);

            if(winConditionMet) {
                Player[] winners = new Player[numWinners];
                int iterate = 0;
                for (Player p : players) {
                    if (p.has21) {
                        p.score += ((float) 1 / numWinners);
                        winners[iterate] = p;
                        iterate++;
                        p.has21 = false;
                    }
                    p.hand.clear();
                }
                OutputUtils.congratulateWinners(winners);
            }
            else {
                System.out.println("Insufficient cards remaining. No points will be awarded this draw.");
            }
            currentGame++;
        }
    }

    private static boolean checkWinCondition(Player p) {
        boolean winConditionMet = false;
        for (String suit : suits) {
            winConditionMet = p.hand.checkWinConditionForSuit(suit);
            if (winConditionMet) {
                System.out.printf("You have 21 in %ss!\n", suit);
                return true;
            }
        }
        return false;
    }

}
