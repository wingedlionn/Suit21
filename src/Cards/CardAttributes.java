package Cards;

public class CardAttributes {
    public enum Suit {
        Spades, Clubs, Diamonds, Hearts
    }

    public static String[] returnSuits() {
        String[] holder = new String[4];
        int iterate = 0;
        for(CardAttributes.Suit suit : CardAttributes.Suit.values()) {
            holder[iterate] = suit.name();
            iterate++;
        }
        return holder;
    }

    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }
}
