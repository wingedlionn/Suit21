package main.Cards;

public class Card implements Comparable<Card> {
    private String suit;
    private String rank;
    private int value;

    public Card(String suit, String rank) {
        setSuit(suit);
        setRank(rank);
        setValue(getInitialValue(rank));
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getInitialValue(String newRank) {
        return switch (newRank) {
            case ("Two") -> 2;
            case ("Three") -> 3;
            case ("Four") -> 4;
            case ("Five") -> 5;
            case ("Six") -> 6;
            case ("Seven") -> 7;
            case ("Eight") -> 8;
            case ("Nine") -> 9;
            case ("Ten"), ("Jack"), ("King"), ("Queen") -> 10;
            case ("Ace") -> 11;
            default -> throw new UnsupportedOperationException("Invalid rank: " + newRank);
        };
    }

    public String toString(){
        return String.format("%s of %s", rank, suit);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(getValue(), o.getValue());
    }
}


