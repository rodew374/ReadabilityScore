package readability;

import java.util.Scanner;

/**
 * This program will scan text and output a readability score.
 * @version 2.0 Words and Sentences. Reads a single line of text and outputs either
 * "HARD", if sentences contain more than 10 words on average, or "EASY", if less.
 */
public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("[.!?]");
        double totalWordCount = 0;
        double sentenceCount = text.length;

        for (String sentence : text) {
            totalWordCount += sentence.trim().split("\\s").length;
        }

        System.out.println(totalWordCount / sentenceCount > 10 ? "HARD" : "EASY");
    }
}
