package Cards;

public interface HandBagInterface {

    public int getSize();
    /* gets the number of cards in the hand

    @return - (int) number of cards
     */

    public boolean add(Card newCard);
    /* checks for space in the bag, adds card if possible

    @param (Card) newCard - card to be added to hand
    @return - (boolean) true if card added successfully, false if no space
     */

    public boolean isEmpty();
    /* Checks if the hand is empty

    @return - (boolean) true if empty, false if contains at least one card
     */

    public boolean clear();
    /* Checks if there are cards in the hand, and removes all present.

    @return - (boolean) true if successful, false if already empty.
     */
    public Card getCardAtIndex(int index);
    /* checks for a card at a certain position, returns card if possible

    @return - (Card) the card at the specified index. null if none found.
     */

    public boolean remove(Card card);
    /* Checks if a card is in the hand, if present is removed

     @param (Card) card - card to be removed from hand
     @return - (boolean) true if card is in hand, otherwise false
     */

    public int getTotalForSuit(String suit);
    /* Takes a suit, checks the hand and returns the total score for the suit.
    If an ace is present, determines if 1 or 10 is a more appropriate score, and changes it as needed.

    @param (String) suit - name of suit for which total is to be found
    @return - (int) total value of the specified suit
    */

    public int[] getCurrentTotals();
    /* Returns a list of the current totals of each suit

    @return - (int[]) list of values of individual suit's scores, in a predetermined order
     */

    public boolean checkWinConditionForSuit(String suit);
    /* Checks if the total for the suit is the win condition (21)

    @params (String) suit - name of suit to check

    @return - (boolean):
             false: Value is not 21, player has not won.
             true: Value is 21, player has won.
     */

    public String toString();
    /* describes the current hand

    @return - (String) a representation of the cards in the hand
     */

}
