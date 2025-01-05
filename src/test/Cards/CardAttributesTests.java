package Cards;

import main.Cards.CardAttributes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CardAttributesTests {
    @Test
    public void CardAttributes_WhenReturnSuitsCalled_StringArrayReturned() {
        String[] check = { "Spades", "Clubs", "Diamonds", "Hearts"};

        String[] returnedArray = CardAttributes.returnSuits();

        assertArrayEquals(check, returnedArray);
    }
}
