package main;

import main.Cards.CardAttributes;
import main.Game.*;
import main.Utils.*;

public class Main {

    public static void main(String[] args) {
        GameLogic.suits = CardAttributes.returnSuits();
        boolean playing = true;
        int numberOfPlayers = 0;
        int numberOfBots = 0;
        Player[] playerHold = new Player[2];
        Player[] botHold = new Player[2];

        OutputUtils.printTitle();
        System.out.println("Welcome!");

        while (playing) {
            GameLogic.currentRound = 1;
            System.out.println("How many players do you have?\nYou must select a number between 1 and 6:");
            numberOfPlayers = InputUtils.getNumPlayers();

            playerHold = SetupUtils.getPlayerNames(numberOfPlayers);

            if(numberOfPlayers == 1) {
                botHold = SetupUtils.getBots(numberOfPlayers);
            } else if (numberOfPlayers < 6) {
                System.out.println("Would you like to play against any bots? (y/n)");
                if(InputUtils.getBotsPlaying()) {
                    botHold = SetupUtils.getBots(numberOfPlayers);
                }
            }

            numberOfBots = botHold.length;

            int totalPlayers = numberOfPlayers + numberOfBots;
            GameLogic.players = new Player[totalPlayers];

            if(numberOfBots == 0) {
                SetupUtils.populatePlayers(playerHold);
            } else {
                SetupUtils.populatePlayers(totalPlayers, playerHold, botHold);
            }
            System.out.println("How many rounds would you like to play?");
            GameLogic.numberOfGames = InputUtils.getNumGames();

            System.out.println("Let's begin!\n");

            GameLogic.playGame();

            playing = InputUtils.getContinuePlaying();
        }

        System.out.println("Thanks for playing!");
    }



}