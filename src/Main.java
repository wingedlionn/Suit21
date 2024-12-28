import Cards.CardAttributes;
import Game.*;
import Utils.*;

public class Main {

    public static void main(String[] args) {
        GameLogic.suits = CardAttributes.returnSuits();
        int numberOfPlayers, numberOfRounds, currentRound = 0;
        OutputUtils.printTitle();
        System.out.println("Welcome! How many players do you have?\nYou must select a number between 2 and 6:");
        numberOfPlayers = InputUtils.getNumPlayers();

        GameLogic.players = new Player[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Player %d name: \n", i+1);
            String name = InputUtils.getPlayerName();
            GameLogic.players[i] = new Player(name);
        }

        System.out.println("Wonderful! How many rounds would you like to play?");

        numberOfRounds = InputUtils.getNumRounds();

        System.out.println("Let's begin!\n");



        GameLogic.playGame();




    }

}