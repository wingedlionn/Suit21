package Utils;

import main.Utils.InputUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InputUtilsTests {

    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalSystemOut);
    }

    @Test
    public void InputUtils_WhenGetPlayerNameCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("", "Name");
        InputUtils.setScanner(mockScanner);

        String name = InputUtils.getPlayerName();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("You cannot leave the player name blank."));
        assertEquals("Name", name);
    }

    @Test
    public void InputUtils_WhenGetCardSwapCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("", "F", "A", "B", "C", "D", "E");
        InputUtils.setScanner(mockScanner);

        String a = InputUtils.getCardSwap();
        String b = InputUtils.getCardSwap();
        String c = InputUtils.getCardSwap();
        String d = InputUtils.getCardSwap();
        String e = InputUtils.getCardSwap();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("You must select a card."));
        assertEquals("A", a);
        assertEquals("B", b);
        assertEquals("C", c);
        assertEquals("D", d);
        assertEquals("E", e);
        assertTrue(output.contains("Invalid Selection."));
    }

    @Test
    public void InputUtils_WhenGetNumPlayersCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test", "0", "3");
        InputUtils.setScanner(mockScanner);

        int input = InputUtils.getNumPlayers();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Invalid input. Please enter a number:"));
        assertTrue(output.contains("Invalid number of players. Please enter a number between 1 and 6:"));
        assertEquals(3, input);
    }

    @Test
    public void InputUtils_WhenGetNumBotsCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test", "0", "3", "2");
        InputUtils.setScanner(mockScanner);

        int input = InputUtils.getNumBots(2);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Invalid input. Please enter a number:"));
        assertTrue(output.contains("Invalid number of bots. Please enter a number between 1 and 2:"));
        assertEquals(2, input);
    }

    @Test
    public void InputUtils_WhenGetNumGamesCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test", "0", "2");
        InputUtils.setScanner(mockScanner);

        int input = InputUtils.getNumGames();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Invalid input. Please enter a number:"));
        assertTrue(output.contains("Invalid number of games. Please enter a number greater than 0:"));
        assertEquals(2, input);
    }

    @Test
    public void InputUtils_WhenGetBotDifficultyCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test", "-1", "3", "2");
        InputUtils.setScanner(mockScanner);

        int input = InputUtils.getBotDifficulty();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Invalid input. Please enter a number:"));
        assertTrue(output.contains("Please select either Easy (1) or Normal (2)"));
        assertEquals(2, input);
    }

    @Test
    public void InputUtils_WhenGetBotsPlayingCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test", "y", "n");
        InputUtils.setScanner(mockScanner);

        boolean trueInput = InputUtils.getBotsPlaying();
        boolean falseInput = InputUtils.getBotsPlaying();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("You must select yes (y) or no (n). Please try again."));
        assertTrue(trueInput);
        assertFalse(falseInput);
    }

    @Test
    public void InputUtils_WhenGetContinuePlayingCalled_CorrectOutputAndReturnsProvided() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Test", "y", "n");
        InputUtils.setScanner(mockScanner);

        boolean trueInput = InputUtils.getContinuePlaying();
        boolean falseInput = InputUtils.getContinuePlaying();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("You must select yes (y) or no (n). Please try again."));
        assertTrue(trueInput);
        assertFalse(falseInput);
    }
}
