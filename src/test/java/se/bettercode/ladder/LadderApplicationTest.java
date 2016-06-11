package se.bettercode.ladder;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Tests the ladder application using command line input and verifying output.
 * A classic system test with a blackbox approach.
 */
public class LadderApplicationTest {

  LadderApplication ladderApplication = new LadderApplication();
  ByteArrayOutputStream out = new ByteArrayOutputStream();

  @Test
  public void runApp() {
    runMainWithInputAndAssertOutput("500 70", "533\n");
    runMainWithInputAndAssertOutput("1000 10", "5759\n");
    runMainWithInputAndAssertOutput("2000 70", "2129\n");
  }

  @Test(expected = NumberFormatException.class)
  public void invalidInput() {
    runMainWithInputAndAssertOutput("500 70asd", "");
  }

  private void runMainWithInputAndAssertOutput(String input, String expectedOutput) {
    out.reset();
    BufferedReader in = new BufferedReader(new StringReader(input));
    ladderApplication.main(in, new PrintStream(out));
    assertEquals(expectedOutput, out.toString());
  }
}
