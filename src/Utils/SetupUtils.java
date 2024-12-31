package Utils;

import Game.GameLogic;
import Game.Player;
import Game.PlayerBot;

public class SetupUtils {

    public static Player[] getPlayerNames(int numberOfPlayers) {
        Player[] playerHold = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Player %d name: \n", i + 1);
            String name = InputUtils.getPlayerName();
            playerHold[i] = new Player(name);
        }

        return playerHold;
    }

    public static void populatePlayers(int totalPlayers, Player[] players, Player[] bots) {
        int counter = 0;
        for(Player p : players) {
            GameLogic.players[counter] = p;
            counter++;
        }
        for(Player p : bots) {
            GameLogic.players[counter] = p;
            counter++;
        }
    }

    public static void populatePlayers(Player[] players) {
        int counter = 0;
        for(Player p : players) {
            GameLogic.players[counter] = p;
            counter++;
        }
    }

    public static Player[] getBots(int numberOfPlayers) {
        int numberOfBots;
        int maxBots = 6 - numberOfPlayers;
        if (maxBots == 1) {
            numberOfBots = 1;
        } else {
            System.out.printf("How many bots would you like? You can have up to %d bots in this game.\n", maxBots);
            numberOfBots = InputUtils.getNumBots(maxBots);
        }

        Player[] botHold = new Player[numberOfBots];

        if(numberOfBots == 1) {
            System.out.println("What difficulty would you like to play against?\nEasy (1)\nNormal (2)");
            int difficulty = InputUtils.getBotDifficulty();
            PlayerBot playerBot = new PlayerBot("COM", difficulty);
            botHold[0] = playerBot;
        } else {
            System.out.println("For each bot, please select which difficulty you would like it to be.\nEasy (1)\nNormal (2)");
            for(int i = 0; i < numberOfBots; i++) {
                String botName = "COM"+(i+1);
                System.out.printf("%s:\n",botName);
                int difficulty = InputUtils.getBotDifficulty();
                PlayerBot playerBot = new PlayerBot(botName, difficulty);
                botHold[i] = playerBot;
            }
        }
        return botHold;
    }
}
