package readability;

import java.util.Scanner;

/**
 * This program will scan text and output a readability score.
 * @version 1.0 Simplest Estimation. Reads a single line of text and outputs either
 * "HARD", if more than 100 symbols, or "EASY", if 100 or less.
 */
public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toCharArray();

        System.out.println(text.length > 100 ? "HARD" : "EASY");
    }
}
