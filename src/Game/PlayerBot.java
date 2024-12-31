package Game;

import Cards.Card;

import java.util.*;

public class PlayerBot extends Player {
    // 1: Easy
    // 2: Normal
    private int difficulty;

    public PlayerBot(String playerName, int difficulty) {
        super(playerName);
        setDifficulty(difficulty);
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Card playTurn() {
        if (difficulty == 1) {
            return pickRandomCard();
        }
        else {
            Map<String, List<Card>> sortedHand = sortCards(hand.getCards());

            String target = getIdealSuit(sortedHand);
            return pickCardToSwap(target, sortedHand);
        }
    }


    private String getIdealSuit(Map<String, List<Card>> cards) {
        String chosenSuit = null;
        int closest = 0;

        for (Map.Entry<String, List<Card>> entry : cards.entrySet()) {
            int score = getScoreFromMap(cards);

            if (score > 21) {
                if(closest < 21) {
                    chosenSuit = entry.getKey();
                    closest = score;
                }
                else if(score < closest) {
                    chosenSuit = entry.getKey();
                    closest = score;
                }
            }

            if(score <= 21 && score > closest) {
                chosenSuit = entry.getKey();
                closest = score;
            }
        }

        return chosenSuit;
    }

    private Card pickCardToSwap(String suit, Map<String, List<Card>> cards) {
        List<Card> cardsOfSuit = cards.getOrDefault(suit, Collections.emptyList());
        int currentScore = getScore(cardsOfSuit);

        if(suit == null) {
            return pickRandomCard();
        }

        if(currentScore > 21) {
            int goalCard = currentScore - 21;

            for(Card card : cardsOfSuit) {
                if(card.getValue() == goalCard) {
                    return card;
                }
            }
            Collections.sort(cardsOfSuit);
            return cardsOfSuit.getLast();
        }


        for(Card card : hand.getCards()) {
            if(!card.getSuit().equals(suit)) {
                return card;
            }
        }

        Collections.sort(cardsOfSuit);
        return cardsOfSuit.getFirst();
    }

    private Card pickRandomCard() {
        Random rand = new Random();
        List<Card> cards = hand.getCards();
        int pickedNumber = rand.nextInt(cards.size());
        return cards.get(pickedNumber);
    }

    private Map<String, List<Card>> sortCards(List<Card> hand) {
        Map<String, List<Card>> cards = new HashMap<>();
        for (Card card : hand) {
            cards.computeIfAbsent(card.getSuit(), s -> new ArrayList<>()).add(card);
        }
        return cards;
    }

    private int getScore(List<Card> cards) {
        int score = 0;
        for (Card card : cards) {
            score += card.getValue();
        }
        return score;
    }

    private int getScoreFromMap(Map<String, List<Card>> cards) {
        int score = 0;
        for (Map.Entry<String, List<Card>> entry : cards.entrySet()) {
            for (Card card : entry.getValue()) {
                score += card.getValue();
            }
        }
        return score;
    }

}
