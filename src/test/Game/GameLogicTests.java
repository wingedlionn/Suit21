package Game;

import main.Cards.Card;
import main.Cards.CardAttributes;
import main.Cards.Deck;
import main.Game.GameLogic;
import main.Game.Player;
import main.Game.PlayerBot;
import main.Utils.InputUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameLogicTests {

    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream outputStream;

    Card twoDiamond = new Card("Diamonds", "Two");
    Card nineDiamond = new Card("Diamonds", "Nine");
    Card tenDiamond = new Card("Diamonds", "Ten");
    Card fourSpade = new Card("Spades", "Four");
    Card fiveSpade = new Card("Spades", "Five");
    Card sevenSpade = new Card("Spades", "Seven");
    Card twoHearts = new Card("Hearts", "Two");
    Card nineHearts = new Card("Hearts", "Nine");
    Card fiveHearts = new Card("Hearts", "Five");
    Card twoClub = new Card("Clubs", "Two");

    Card threeClub = new Card("Clubs", "Three");
    Card fourClub = new Card("Clubs", "Four");
    Card fiveClub = new Card("Clubs", "Five");
    Card sixClub = new Card("Clubs", "Six");

    ArrayList<Card> hand1 = new ArrayList<Card>(Arrays.asList(twoDiamond, nineDiamond, tenDiamond, fourSpade, fiveSpade));
    ArrayList<Card> hand2 = new ArrayList<>(Arrays.asList(sevenSpade, twoHearts, nineHearts, fiveHearts, twoClub));

    ArrayList<Card> deck1 = new ArrayList<>(Arrays.asList(threeClub, fourClub, fiveClub, sixClub));
    ArrayList<Card> deck2 = new ArrayList<>(Arrays.asList(threeClub, fourClub, fiveClub));

    Deck deck = new Deck();

    @BeforeEach
    public void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameLogic.numberOfGames = 1;
        GameLogic.suits = CardAttributes.returnSuits();
        GameLogic.isTestScenario = true;
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalSystemOut);
    }

    @Test
    public void GameLogic_WhenPlayGameCalledAndPlayerWins_GameOutputInConsole() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("D", "\n", "B", "\n", "\n", "\n");
        InputUtils.setScanner(mockScanner);

        deck.cards.clear();
        deck.cards.addAll(deck1);
        GameLogic.deck = deck;
        GameLogic.players = new Player[]{ new Player("Test 1"), new Player("Test 2") };
        GameLogic.players[0].hand.addHand(hand1);
        GameLogic.players[1].hand.addHand(hand2);

        boolean complete = GameLogic.playGame();
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Four of Spades has been replaced by the Three of Clubs"));
        assertTrue(output.contains("You have 21 in Diamonds!"));
        assertTrue(output.contains("Two of Hearts has been replaced by the Four of Clubs"));
        assertTrue(output.contains("Results:\n1: Test 1 - 1.00 point(s)\n2: Test 2 - 0.00 point(s)"));

        assertTrue(complete);
    }

    @Test
    public void GameLogic_WhenPlayGameCalledAndDeckInsufficient_GameOutputInConsole() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("A", "\n", "B", "\n", "\n", "\n");
        InputUtils.setScanner(mockScanner);

        deck.cards.clear();
        deck.cards.addAll(deck2);
        GameLogic.deck = deck;
        GameLogic.players = new Player[]{ new Player("Test 1"), new Player("Test 2") };
        GameLogic.players[0].hand.addHand(hand1);
        GameLogic.players[1].hand.addHand(hand2);

        boolean complete = GameLogic.playGame();
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Game over\nInsufficient cards remaining to continue the game.\nNo points will be awarded for this game."));

        assertTrue(complete);
    }

    @Test
    public void GameLogic_WhenBotPlayerInGameAndGameLogicCalled_GameOutputInConsole() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("B", "\n", "\n", "\n", "\n");
        InputUtils.setScanner(mockScanner);

        deck.cards.clear();
        deck.cards.addAll(deck2);
        GameLogic.deck = deck;
        GameLogic.players = new Player[]{ new Player("Test 1"), new PlayerBot("Com1", 2) };
        GameLogic.players[1].hand.addHand(hand1);
        GameLogic.players[0].hand.addHand(hand2);
        boolean complete = GameLogic.playGame();

        String output = outputStream.toString().trim();

        assertTrue(output.contains("Com1's current hand:"));
        assertTrue(output.contains("Com1 swaps Four of Spades for Four of Clubs"));
        assertTrue(complete);
    }
}
