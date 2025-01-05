package Cards;

import main.Cards.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTests {

    @Test
    public void Deck_WhenNewDeckInitialised_DeckIsPopulated() {
        Deck deck = new Deck();

        assertNotNull(deck);
        assertEquals(52, deck.cards.size());
    }

    @Test
    public void Deck_WhenResetDeckCalled_DeckIsReinitialized() {
        Deck deck = new Deck();
        for(int i = 0; i < 30; i++) {
            deck.cards.removeFirst();
        }
        assertNotEquals(52, deck.cards.size());

        deck.resetDeck();

        assertEquals(52, deck.cards.size());
    }

    @Test
    public void Deck_WhenDealHandCalled_NewHandReturned() {
        Deck deck = new Deck();
        List<Card> hand = deck.dealHand();

        assertEquals(5, hand.size());
    }


}
