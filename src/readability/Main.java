package readability;

import java.io.IOException;
import java.util.Scanner;

/**
 * This program will scan text and output a readability score.
 * @version 4.10 May 29 2021 Readability Indices. Reads a text file and calculates the Automated Readability Index (ARI), the Flesch-Kincaid
 * Index (FKI), the Simple Measure of Gobbledygook (SMOG), and the Coleman-Liau Index (CLI).
 * This program requires the path of the text file to be examined as a command line argument.
 */
public class Main {
    public static void main(String[] arg) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Text text = new Text(arg[0]);

        text.displayData();

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        text.displayScore(scanner.next());
    }
}
