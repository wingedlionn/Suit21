package Game;

import main.Cards.Card;
import main.Cards.Deck;
import main.Game.PlayerBot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerBotTests {
    Card tenDiamond = new Card("Diamonds", "Ten");
    Card aceDiamond = new Card("Diamonds", "Ace");
    Card sevenDiamond = new Card("Diamonds", "Seven");
    Card twoDiamond = new Card("Diamonds", "Two");
    Card twoSpade = new Card("Spades", "Two");
    Card threeSpade = new Card("Spades", "Three");
    Card eightClub = new Card("Clubs", "Eight");

    ArrayList<Card> under21 = new ArrayList<>(Arrays.asList(tenDiamond, sevenDiamond, twoDiamond, twoSpade, eightClub));
    ArrayList<Card> is21 = new ArrayList<>(Arrays.asList(tenDiamond, aceDiamond, threeSpade, twoSpade, eightClub));
    ArrayList<Card> over21 = new ArrayList<>(Arrays.asList(tenDiamond, aceDiamond, sevenDiamond, threeSpade, twoSpade));



    @Test
    public void PlayerBot_WhenDifficultyIsEasy_RandomCardSelected() {
        PlayerBot bot = new PlayerBot("Bot", 1);
        Deck deck = new Deck();

        bot.hand.addHand(deck.dealHand());

        Card card = bot.playTurn();

        assertNotNull(card);
    }

    @Test
    public void PlayerBot_WhenDifficultyIsMediumAndHandUnder21_SpecificCardSelected() {
        PlayerBot bot = new PlayerBot("Bot", 2);

        bot.hand.addHand(under21);

        Card card = bot.playTurn();

        assertEquals(twoSpade, card);

    }

    @Test
    public void PlayerBot_WhenDifficultyIsMediumAndHandIs21_SpecificCardSelected() {
        PlayerBot bot = new PlayerBot("Bot", 2);

        bot.hand.addHand(is21);

        Card card = bot.playTurn();

        assertEquals(threeSpade, card);
    }

    @Test
    public void PlayerBot_WhenDifficultyIsMediumAndHandOver21_SpecificCardSelected() {
        PlayerBot bot = new PlayerBot("Bot", 2);
        bot.hand.addHand(over21);
        Card card = bot.playTurn();
        assertEquals(sevenDiamond, card);
    }
}
