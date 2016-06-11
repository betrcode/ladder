package se.bettercode.ladder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Takes a roof height and a ladder angle from standard input, on a single line
 * and calculates the needed length of the ladder to reach the roof and prints the result
 * to standard out.
 */
public class LadderApplication {
  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintStream out = new PrintStream(System.out);
    main(in, out);
  }

  /**
   * Testable method
   */
  public static void main(BufferedReader in, PrintStream out) {
    Entry<Integer, Integer> entry = readInput(in);
    final double ladderLength = getLadderLength(entry.getKey(), entry.getValue());
    printOutput(ladderLength, out);
  }

  /**
   * Reads input from provided reader.
   * Note: No error handling. Assumes two integers separated by space. Will crash on other values.
   */
  private static Entry<Integer, Integer> readInput(BufferedReader reader) {
    final Scanner in = new Scanner(reader);
    final String line = in.nextLine();
    final String[] split = line.split("\\s+");
    //Using a Map Entry here but a Apache Commons Pair would be nicer
    return new SimpleImmutableEntry<>(new Integer(split[0]), new Integer(split[1]));
  }

  /**
   * Calculates the needed length of the ladder using Pythagorean theorem, sin(angle) = roofHeight / ladderLength
   */
  private static double getLadderLength(Integer roofHeight, Integer angle) {
    return roofHeight / Math.sin(Math.toRadians(angle));
  }

  private static void printOutput(double ladderLength, PrintStream out) {
    out.println((int)Math.ceil(ladderLength));
  }

}
