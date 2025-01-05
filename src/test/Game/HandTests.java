package Game;

import main.Cards.Card;
import main.Cards.Deck;
import main.Game.Hand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandTests {
    Deck deck;

    @Test
    public void Hand_WhenGetSizeCalled_SizeOfHandReturned() {
        Hand hand = new Hand();
        deck = new Deck();

        assertEquals(0, hand.getSize());

        Deck deck = new Deck();
        hand.addHand(deck.dealHand());
        assertEquals(5, hand.getSize());
        assertEquals(hand.getCards().size(), hand.getSize());
    }

    @Test
    public void Hand_WhenGetCardsCalled_CardArrayReturned() {
        Hand hand = new Hand();
        deck = new Deck();

        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        assertEquals(cards, hand.getCards());
    }

    @Test
    public void Hand_WhenIsEmptyCalledAndHandIsEmpty_ReturnTrue() {
        Hand hand = new Hand();
        deck = new Deck();

        assertTrue(hand.isEmpty());
        assertEquals(0, hand.getSize());
    }

    @Test
    public void Hand_WhenIsEmptyCalledAndHandIsNotEmpty_ReturnFalse() {
        Hand hand = new Hand();
        deck = new Deck();

        hand.addHand(deck.dealHand());

        assertFalse(hand.isEmpty());
        assertNotEquals(0, hand.getSize());
    }

    @Test
    public void Hand_WhenSizeEqualsMaxCapacityAndAddCardCalled_ReturnFalse() {
        Hand hand = new Hand();
        deck = new Deck();

        hand.addHand(deck.dealHand());

        Card newCard = deck.cards.getFirst();

        assertFalse(hand.add(newCard));
    }

    @Test
    public void Hand_WhenSizeLessThanMaxCapacityAndAddCardCalled_ReturnTrueAndCardAdded() {
        Hand hand = new Hand();
        deck = new Deck();

        int initialSize = hand.getSize();

        Card newCard = deck.cards.getFirst();
        assertTrue(hand.add(newCard));

        assertNotEquals(initialSize, hand.getSize());
    }

    @Test
    public void Hand_WhenEmptyAndAddHandCalled_ReturnTrue() {
        Hand hand = new Hand();
        deck = new Deck();

        boolean result = hand.addHand(deck.dealHand());
        assertTrue(result);
        assertFalse(hand.isEmpty());
    }

    @Test
    public void Hand_WhenFullAndAddHandCalled_ReturnFalse() {
        Hand hand = new Hand();
        deck = new Deck();

        hand.addHand(deck.dealHand());

        boolean result = hand.addHand(deck.dealHand());

        assertFalse(result);
    }

    @Test
    public void Hand_WhenClearCalledAndCardsNotEmpty_ReturnTrue() {
        Hand hand = new Hand();
        deck = new Deck();

        hand.addHand(deck.dealHand());

        boolean response = hand.clear();
        assertTrue(response);
        assertTrue(hand.isEmpty());
    }

    @Test
    public void Hand_WhenClearCalledAndHandIsEmpty_ReturnFalse() {
        Hand hand = new Hand();
        deck = new Deck();

        boolean response = hand.clear();
        assertFalse(response);
    }

    @Test
    public void Hand_WhenGetCardAtIndexCalledAndIndexIsValid_ReturnCard() {
        Hand hand = new Hand();
        deck = new Deck();

        ArrayList<Card> cards = deck.dealHand();

        hand.addHand(cards);

        Card cardAtIndex = cards.get(3);

        assertEquals(cardAtIndex, hand.getCardAtIndex(3));
    }

    @Test
    public void Hand_WhenGetCardAtIndexCalledAndIndexIsInvalid_ReturnNull() {
        Hand hand = new Hand();
        deck = new Deck();

        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        assertNull(hand.getCardAtIndex(6));
    }

    @Test
    public void Hand_WhenGetIndexOfCardCalledWithValidCard_ReturnIndex() {
        Hand hand = new Hand();
        deck = new Deck();
        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        Card checkCard = cards.get(2);

        int index = hand.getIndexOfCard(checkCard);

        assertEquals(2, index);
    }

    @Test
    public void Hand_WhenGetIndexOfCardCalledWithInvalidCard_ReturnMinus1() {
        Hand hand = new Hand();
        deck = new Deck();
        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        Card checkCard = deck.cards.getFirst();

        int index = hand.getIndexOfCard(checkCard);

        assertEquals(-1, index);
    }


    @Test
    public void Hand_WhenRemoveCalledWithValidCard_ReturnTrue() {
        Hand hand = new Hand();
        deck = new Deck();
        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        Card cardToRemove = cards.get(1);

        boolean response = hand.remove(cardToRemove);

        assertTrue(response);
        assertEquals(4, hand.getSize());
        assertEquals(-1, hand.getIndexOfCard(cardToRemove));
    }

    @Test
    public void Hand_WhenRemoveCalledWithInvalidCard_ReturnFalse() {
        Hand hand = new Hand();
        deck = new Deck();
        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        Card cardToRemove = deck.cards.getFirst();

        boolean response = hand.remove(cardToRemove);

        assertFalse(response);
        assertEquals(5, hand.getSize());
    }

    @Test
    public void Hand_WhenRemoveCardAtIndexCalledWithValidIndex_ReturnTrue() {
        Hand hand = new Hand();
        deck = new Deck();
        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        Card cardToRemove = cards.get(2);

        boolean response = hand.removeCardAtIndex(2);

        assertTrue(response);
        assertEquals(4, hand.getSize());
        assertEquals(-1, hand.getIndexOfCard(cardToRemove));
    }

    @Test
    public void Hand_WhenRemoveCardAtIndexCalledWithInvalidIndex_ReturnFalse() {
        Hand hand = new Hand();
        deck = new Deck();
        ArrayList<Card> cards = deck.dealHand();
        hand.addHand(cards);

        boolean response = hand.removeCardAtIndex(7);

        assertFalse(response);
    }

    @Test
    public void Hand_WhenGetTotalForSuitCalledWithEmptyHand_ReturnZero() {
        Hand hand = new Hand();
        int total = hand.getTotalForSuit("Clubs");
        assertEquals(0, total);
    }

    @Test
    public void Hand_WhenGetTotalForSuitCalledWithMatchingSuit_ReturnCorrectTotal() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "Five");
        Card card2 = new Card("Clubs", "Ace");
        Card card3 = new Card("Diamonds", "Ten");

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3));
        hand.addHand(cards);

        int total = hand.getTotalForSuit("Clubs");
        assertEquals(16, total);
    }

    @Test
    public void Hand_WhenGetTotalForSuitCalledWithNonMatchingSuit_ReturnZero() {
        Hand hand = new Hand();
        Card card1 = new Card("Diamonds", "Five");
        Card card2 = new Card("Diamonds", "Ace");
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2));
        hand.addHand(cards);

        int total = hand.getTotalForSuit("Clubs");
        assertEquals(0, total);
    }

    @Test
    public void Hand_WhenGetTotalForSuitCalledWithOver21AdjustAce_ReturnCorrectTotal() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "Ace");
        Card card2 = new Card("Clubs", "Ten");
        Card card3 = new Card("Clubs", "Three");
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3));
        hand.addHand(cards);

        int total = hand.getTotalForSuit("Clubs");
        assertEquals(24, total);
    }

    @Test
    public void Hand_WhenGetTotalForSuitCalledWithEdgeCaseValues_HandleCorrectly() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "King");
        Card card2 = new Card("Clubs", "Jack");
        Card card3 = new Card("Clubs", "Ace");
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card3, card2));
        hand.addHand(cards);

        int total = hand.getTotalForSuit("Clubs");
        assertEquals(21, total);
    }

    @Test
    public void Hand_WhenGetCurrentTotalsCalled_ReturnValues() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "King");
        Card card2 = new Card("Diamonds", "Two");
        Card card3 = new Card("Clubs", "Four");
        Card card4 = new Card("Spades", "Jack");
        Card card5 = new Card("Diamonds", "Nine");

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5));
        hand.addHand(cards);
        // Order: Spades, Clubs, Diamonds, Hearts

        int[] totals = hand.getCurrentTotals();

        assertEquals(4, totals.length);
        assertEquals(10, totals[0]);
        assertEquals(14, totals[1]);
        assertEquals(11, totals[2]);
        assertEquals(0, totals[3]);
    }

    @Test
    public void Hand_WhenCheckWinConditionsCalledWithSuccessInput_ReturnTrue() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "King");
        Card card2 = new Card("Clubs", "Nine");
        Card card3 = new Card("Clubs", "Two");
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3));

        hand.addHand(cards);

        boolean result = hand.checkWinConditionForSuit("Clubs");

        assertTrue(result);
    }

    @Test
    public void Hand_WhenCheckWinConditionsCalledWithFailInput_ReturnFalse() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "King");
        Card card2 = new Card("Clubs", "Nine");
        Card card3 = new Card("Clubs", "Three");
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3));

        hand.addHand(cards);

        boolean result = hand.checkWinConditionForSuit("Clubs");

        assertFalse(result);
    }

    @Test
    public void Hand_WhenToStringCalledWithCardsInHand_ReturnFormattedString() {
        Hand hand = new Hand();
        Card card1 = new Card("Clubs", "King");
        Card card2 = new Card("Diamonds", "Nine");
        Card card3 = new Card("Clubs", "Three");
        Card card4 = new Card("Spades", "Jack");
        Card card5 = new Card("Hearts", "Eight");
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5));
        hand.addHand(cards);

        String response = hand.toString();

        assertEquals("A: King of Clubs\nB: Nine of Diamonds\nC: Three of Clubs\nD: Jack of Spades\nE: Eight of Hearts", response);
    }

    @Test
    public void Hand_WhenToStringCalledWithNoCardsInHand_ReturnResponse() {
        Hand hand = new Hand();

        String response = hand.toString();

        assertEquals("Empty Hand", response);
    }


}

