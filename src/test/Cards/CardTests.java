package Cards;

import main.Cards.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CardTests {

    String spades = "Spades";
    String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

    @Test
    public void Card_WhenCardInitialisedAndRankProvided_CorrectValueReturned() {
        for(int i = 0; i < 8; i++) {
            Card c = new Card(spades, ranks[i]);
            assertEquals(i + 2, c.getValue());
        }

        for (int i = 8; i < 12 ; i++) {
            Card c = new Card(spades, ranks[i]);
            assertEquals(10, c.getValue());
        }

        Card c = new Card(spades, ranks[ranks.length-1]);
        assertEquals(11, c.getValue());
    }

    @Test
    public void Card_WhenInvalidRankProvided_ExceptionThrown() {
        Card c = new Card(spades, "Two");

        assertThrows(UnsupportedOperationException.class, () -> c.getInitialValue("Invalid Rank"));
    }

    @Test
    public void Card_WhenToStringCalled_CorrectFormatReturned() {
        Card c = new Card(spades, "Two");

        assertEquals("Two of Spades", c.toString());
    }
}
