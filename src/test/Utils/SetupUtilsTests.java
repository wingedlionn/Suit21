package Utils;

import main.Game.GameLogic;
import main.Game.Player;
import main.Game.PlayerBot;
import main.Utils.InputUtils;
import main.Utils.SetupUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SetupUtilsTests {

    Player[] players = new Player[]{ new Player("Test1"), new Player("Test2") };
    Player[] bots = new Player[]{ new PlayerBot("Bot1", 1), new PlayerBot("Bot2", 2) };
    int totalPlayers = players.length + bots.length;

    @Test
    public void SetupUtils_WhenGetPlayerNamesCalled_ListOfPlayersReturned() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test1", "Test2", "Test3");
        InputUtils.setScanner(mockScanner);

        Player[] players = SetupUtils.getPlayerNames(3);

        assertEquals(3, players.length);
        assertEquals("Test1", players[0].getName());
        assertEquals("Test2", players[1].getName());
        assertEquals("Test3", players[2].getName());
    }

    @Test
    public void SetupUtils_WhenPopulatePlayersCalledWithThreeArgs_PlayersListUpdated() {
        SetupUtils.populatePlayers(totalPlayers, players, bots);

        assertEquals(totalPlayers, GameLogic.players.length);
        assertEquals("Test1", GameLogic.players[0].getName());
        assertEquals("Test2", GameLogic.players[1].getName());
        assertEquals("Bot1", GameLogic.players[2].getName());
        assertEquals("Bot2", GameLogic.players[3].getName());
    }

    @Test
    public void SetupUtils_WhenPopulatePlayersCalledWithOneArg_PlayersListUpdated() {
        SetupUtils.populatePlayers(players);

        assertEquals(players.length, GameLogic.players.length);
        assertEquals("Test1", GameLogic.players[0].getName());
        assertEquals("Test2", GameLogic.players[1].getName());
    }

    @Test
    public void SetupUtils_WhenGetBotsCalledWithSixPlayers_EmptyPlayerListReturned() {
        Player[] bots = SetupUtils.getBots(6);

        assertEquals(0, bots.length);
    }

    @Test
    public void SetupUtils_WhenGetBotsCalledWithOnePlayerAndTwoBots_TwoBotsReturned() {
        String simulatedInput = "2\n1\n2";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        Player[] bots = SetupUtils.getBots(1);

        assertEquals(2, bots.length);
        assertEquals("COM1", bots[0].getName());
        assertEquals("COM2", bots[1].getName());
    }

    @Test
    public void SetupUtils_WhenGetBotsCalledWithFivePlayers_OneBotReturned() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("1");
        InputUtils.setScanner(mockScanner);

        Player[] bots = SetupUtils.getBots(5);

        assertEquals(1, bots.length);
        assertEquals("COM", bots[0].getName());
    }

    @Test
    public void SetupUtils_WhenGetBotsCalledWithThreePlayersAndTwoBotsRequested_TwoBotsReturned() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("2", "1", "2");
        InputUtils.setScanner(mockScanner);

        Player[] bots = SetupUtils.getBots(3);
        assertEquals(2, bots.length);
        assertEquals("COM1", bots[0].getName());
        assertEquals("COM2", bots[1].getName());
    }

}
