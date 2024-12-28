package Game;

import Cards.Card;
import Cards.CardAttributes;
import Cards.HandBagInterface;

import java.util.ArrayList;

public class Hand implements HandBagInterface {
    private ArrayList<Card> cards;
    private int sizeOfHand;
    private static final int MAX_CAPACITY = 5;

    public Hand() {
        cards = new ArrayList<Card>(5);
    }

    public int getSize() {
        return sizeOfHand;
    }

    public boolean isEmpty() {
        return sizeOfHand == 0;
    }

    public boolean add(Card newCard) {
        if(getSize() < MAX_CAPACITY) {
            cards.add(newCard);
            sizeOfHand++;
            return true;
        }
        return false;
    }

    public boolean addHand(ArrayList<Card> hand) {
        try {
            for (Card card : hand) {
                cards.add(card);
                sizeOfHand++;
            }
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public boolean remove(Card card) {
        boolean removed = cards.removeIf(c -> c.equals(card));
        if(removed) {
            sizeOfHand--;
            return true;
        }
        return false;
    }

    public int getTotalForSuit(String suit) {
        int count = 0;
        for(Card card : cards) {
            if(card.getSuit().equals(suit)) {
                if(card.getRank().equals("Ace")) {
                    int checkVal = count + card.getValue();
                    if ((count >= 21 || checkVal > 21) && card.getValue() == 10) {
                        card.setValue(1);
                    }
                    if (count <= 11 && card.getValue() == 1)
                    {
                        card.setValue(10);
                    }
                }
                count += card.getValue();
            }
        }
        return count;
    }

    public int[] getCurrentTotals() {
        int[] hold = new int[4];
        int currentSuit = 0;
        for(CardAttributes.Suit suit : CardAttributes.Suit.values()) {
            hold[currentSuit] = getTotalForSuit(suit.name());
            currentSuit++;
        }
        return hold;
    }

    public boolean checkWinConditionForSuit(String suit) {
        return getTotalForSuit(suit) == 21;
    }

    public String toString() {
        Character[] letters = {'A', 'B', 'C', 'D', 'E'};
        String response;

        response = String.format("%s: %s", letters[0], cards.getFirst().toString());

        for(int i = 1; i < sizeOfHand; i++) {
            response = String.format("%s\n%s: %s", response, letters[i], cards.get(i).toString());
        }

        return response;
    }
}
