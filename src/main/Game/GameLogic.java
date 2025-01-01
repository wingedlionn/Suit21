package main.Game;

import main.Cards.*;
import main.Utils.*;

import java.util.Arrays;

public class GameLogic {
    public static String[] suits;
    public static Player[] players;
    public static int numberOfGames;
    public static int currentGame = 1;
    public static int currentRound;
    public static boolean isTestScenario = false;
    public static Deck deck;

    public static boolean playGame() {
        for (int i = 0; i < numberOfGames; i++) {
            OutputUtils.printGameBar(currentGame);
            boolean winConditionMet = false;
            int numWinners = 0;

            if(!isTestScenario) {
                deck = new Deck();

                for (Player p : players) {
                    p.hand.addHand(deck.dealHand());
                }
            }

            currentRound = 1;
            do {
                OutputUtils.printRoundBar(currentRound);


                for (Player p : players) {

                    OutputUtils.printPlayerBar(p.getName());

                    if (p instanceof PlayerBot) {
                        OutputUtils.printComputerHand(p.hand.toString(), p.getName(), false);

                        Card selectedCard = ((PlayerBot) p).playTurn();
                        int index = p.hand.getIndexOfCard(selectedCard);
                        p.hand.removeCardAtIndex(index);

                        Card newCard = deck.cards.getFirst();
                        deck.cards.removeFirst();

                        p.hand.add(newCard);

                        System.out.printf("%s swaps %s for %s\n", p.getName(), selectedCard.toString(), newCard.toString());

                    } else {
                        OutputUtils.printCurrentHand(p.hand.toString(), false);
                        OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());

                        String selectedCard = InputUtils.getCardSwap();
                        String removedCard = "";

                        switch (selectedCard.toUpperCase()) {
                            case "A":
                                removedCard = p.hand.getCardAtIndex(0).toString();
                                p.hand.removeCardAtIndex(0);
                                break;
                            case "B":
                                removedCard = p.hand.getCardAtIndex(1).toString();
                                p.hand.removeCardAtIndex(1);
                                break;
                            case "C":
                                removedCard = p.hand.getCardAtIndex(2).toString();
                                p.hand.removeCardAtIndex(2);
                                break;
                            case "D":
                                removedCard = p.hand.getCardAtIndex(3).toString();
                                p.hand.removeCardAtIndex(3);
                                break;
                            case "E":
                                removedCard = p.hand.getCardAtIndex(4).toString();
                                p.hand.removeCardAtIndex(4);
                                break;
                        }

                        System.out.printf("%s has been replaced by the %s.\n", removedCard, deck.cards.getFirst().toString());
                        p.hand.add(deck.cards.getFirst());
                        deck.cards.removeFirst();
                        OutputUtils.printCurrentHand(p.hand.toString(), true);
                        OutputUtils.printTotalsPerSuit(p.hand.getCurrentTotals());
                    }


                    if (checkWinCondition(p)) {
                        p.setHas21(true);
                        winConditionMet = true;
                        numWinners++;
                    }

                    System.out.println("\nEnd of turn \n\n");
                    InputUtils.awaitInput();
                }
                currentRound++;
            } while (!winConditionMet && deck.cards.size() >= players.length);

            if (winConditionMet) {
                Player[] winners = new Player[numWinners];
                int iterate = 0;
                for (Player p : players) {
                    if (p.getHas21()) {
                        p.setScore(p.getScore() + (float) 1 / numWinners);
                        winners[iterate] = p;
                        iterate++;
                        p.setHas21(false);
                    }
                    p.hand.clear();
                }
                OutputUtils.congratulateWinners(winners);
            } else {
                System.out.println("\nGame over\nInsufficient cards remaining to continue the game.\nNo points will be awarded for this game.");
            }
            currentGame++;
        }

        Arrays.sort(players);
        OutputUtils.printLeaderboard(players);
        return true;
    }

    private static boolean checkWinCondition(Player p) {
        boolean winConditionMet = false;
        for (String suit : suits) {
            boolean check;
            check = p.hand.checkWinConditionForSuit(suit);
            if (check) {
                System.out.printf("You have 21 in %s!\n", suit);
                winConditionMet = true;
            }
        }
        return winConditionMet;
    }

}
