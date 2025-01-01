package Utils;

import main.Cards.CardAttributes;
import main.Game.GameLogic;
import main.Game.Player;
import main.Utils.OutputUtils;
import main.Utils.SetupUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OutputUtilsTests {

    @Test
    public void OutputUtils_WhenPrintTitleCalled_TitleIsPrintedInConsole() {
        String title =
                """
                         ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄     ▄▄▄▄    \s
                        ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌  ▄█░░░░▌   \s
                        ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌ ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌ ▐░░▌▐░░▌   \s
                        ▐░▌          ▐░▌       ▐░▌     ▐░▌          ▐░▌                    ▐░▌  ▀▀ ▐░░▌   \s
                        ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌     ▐░▌          ▐░▌                    ▐░▌     ▐░░▌   \s
                        ▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌          ▐░▌           ▄▄▄▄▄▄▄▄▄█░▌     ▐░░▌   \s
                         ▀▀▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌     ▐░▌          ▐░▌          ▐░░░░░░░░░░░▌     ▐░░▌   \s
                                  ▐░▌▐░▌       ▐░▌     ▐░▌          ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀      ▐░░▌   \s
                         ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄█░█▄▄▄▄      ▐░▌          ▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄█░░█▄▄▄\s
                        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
                         ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀\s
                                                                                                          \s""";


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printTitle();

        String output = outputStream.toString();

        assertTrue(output.contains(title));
    }

    @Test
    public void OutputUtils_WhenPrintGameBarCalled_GameBarIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printGameBar(1);

        String output = outputStream.toString().trim();

        assertEquals("""
                ##############################
                ########### Game 1 ###########
                ##############################""", output);
    }

    @Test
    public void OutputUtils_WhenPrintGameBarCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printGameBar(0);
        String output = outputStream.toString().trim();
        assertEquals("Invalid game number", output);
    }

    @Test
    public void OutputUtils_WhenPrintRoundBarCalled_RoundBarIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printRoundBar(1);

        String output = outputStream.toString().trim();

        assertEquals("----- Round 1 ------", output);
    }

    @Test
    public void OutputUtils_WhenPrintRoundBarCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printRoundBar(0);
        String output = outputStream.toString().trim();
        assertEquals("Invalid round number", output);
    }

    @Test
    public void OutputUtils_WhenPrintPlayerBarCalled_PlayerBarIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printPlayerBar("Player");

        String output = outputStream.toString();

        assertEquals("Player's turn\n\n", output);
    }

    @Test
    public void OutputUtils_WhenPrintPlayerBarCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printPlayerBar("");
        String output = outputStream.toString().trim();
        assertEquals("Invalid player name", output);
    }

    @Test
    public void OutputUtils_WhenPrintCurrentHandCalledAsRedraw_OutputIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printCurrentHand("Test", true);

        String output = outputStream.toString().trim();

        assertEquals("Your new hand:\nTest", output);
    }

    @Test
    public void OutputUtils_WhenPrintCurrentHandCalledNotAsRedraw_OutputIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printCurrentHand("Test", false);

        String output = outputStream.toString().trim();

        assertEquals("Your current hand:\nTest", output);
    }

    @Test
    public void OutputUtils_WhenPrintCurrentHandCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printCurrentHand("", false);
        String output = outputStream.toString().trim();
        assertEquals("Hand cannot be empty", output);
    }

    @Test
    public void OutputUtils_WhenPrintComputerHandCalledAsRedraw_OutputIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printComputerHand("Test", "Computer", true);

        String output = outputStream.toString().trim();

        assertEquals("Computer's new hand:\nTest", output);
    }

    @Test
    public void OutputUtils_WhenPrintComputerHandCalledNotAsRedraw_OutputIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printComputerHand("Test", "Computer", false);

        String output = outputStream.toString().trim();

        assertEquals("Computer's current hand:\nTest", output);
    }

    @Test
    public void OutputUtils_WhenPrintComputerHandCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printComputerHand("", "Name", false);
        OutputUtils.printComputerHand("Test", "", false);
        String output = outputStream.toString().trim();
        assertEquals("Hand cannot be empty\nComputer's current hand:\nTest", output);
    }

    @Test
    public void OutputUtils_WhenPrintTotalsPerSuitCalled_OutputIsPrintedInConsole() {
        GameLogic.suits = CardAttributes.returnSuits();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        int[] vals = {1, 2, 3, 4};
        OutputUtils.printTotalsPerSuit(vals);

        String output = outputStream.toString().trim();
        assertEquals("Card totals:\nSpades: 1\nClubs: 2\nDiamonds: 3\nHearts: 4", output);
    }

    @Test
    public void OutputUtils_WhenPrintTotalsPerSuitCalledWithInvalidParam_ExceptionIsHandled() {

        GameLogic.suits = CardAttributes.returnSuits();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printTotalsPerSuit(new int[0]);

        String output = outputStream.toString().trim();
        assertEquals("Invalid values provided", output);
    }

    @Test
    public void OutputUtils_WhenCongratulateWinnersCalled_OutputIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Player[] test1 = { new Player("Test1"), new Player("Test2")};
        Player[] test2 = { new Player("Test3")};

        OutputUtils.congratulateWinners(test1);
        OutputUtils.congratulateWinners(test2);
        String output = outputStream.toString().trim();
        assertEquals("Congratulations! You have won the game!\nWinners:\nTest1\nTest2\nCongratulations! You have won the game!\nWinner: Test3", output);
    }

    @Test
    public void OutputUtils_WhenCongratulateWinnersCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.congratulateWinners(new Player[0]);

        String output = outputStream.toString().trim();
        assertEquals("Invalid input provided", output);
    }

    @Test
    public void OutputUtils_WhenPrintLeaderboardCalled_OutputIsPrintedInConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Player[] players = { new Player("Test1"), new Player("Test2")};
        players[0].setScore(3.5f);
        players[1].setScore(4);
        Arrays.sort(players);

        OutputUtils.printLeaderboard(players);
        String output = outputStream.toString().trim();
        assertEquals("Results:\n1: Test2 - 4.00 point(s)\n2: Test1 - 3.50 point(s)", output);
    }

    @Test
    public void OutputUtils_WhenPrintLeaderboardCalledWithInvalidParam_ExceptionIsHandled() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        OutputUtils.printLeaderboard(new Player[0]);

        String output = outputStream.toString().trim();
        assertEquals("Invalid input provided", output);
    }




}
