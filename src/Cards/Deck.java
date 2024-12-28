package Cards;

import java.util.ArrayList;
import java.util.Collections;
import Cards.CardAttributes.*;


public class Deck {
    public ArrayList<Card> cards;

    public Deck() {
        resetDeck();
    }

    public void resetDeck()
    {
        cards = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cards.add(new Card(suit.name(), rank.name()));
            }
        }

        shuffleDeck();
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> dealHand() {
        ArrayList<Card> hand = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            hand.add(cards.getFirst());
            cards.removeFirst();
        }
        return hand;
    }

}
