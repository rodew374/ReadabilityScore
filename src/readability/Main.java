package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This program will scan text and output a readability score.
 * @version 3.10 Apr 05 2021 Automated Readability Index. Reads a text file and calculates the ARI score.
 * score = 4.71 * characters/words + 0.5 * words/sentences - 21.43
 */
public class Main {
    public static void main(String[] arg) throws IOException {
        String text = readFileAsString(arg[0]);
        double score;
        int words;
        int sentences;
        int characters;
        String ageRange;

        characters = text.replaceAll("\\s", "").split("").length;
        words = text.split("\\s").length;
        sentences = text.split("[.?!]").length;

        score = 4.71 * characters/words + 0.5 * words/sentences - 21.43;

        ageRange = getAgeRange(score);

        System.out.printf("The text is:\n%s\nWords: %d\nSentences: %d\nCharacters: %d\nThe score is: %,.2f\nThis text should be " +
                "understood" +
                " by %s-year-olds.", text, words, sentences, characters, score, ageRange);
    }

    /**
     * Reads a file and returns the data as a single String
     * @param fileName the path to the file
     * @return a string containing the data from the file
     */
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    /**
     * Returns a String containing the appropriate Age Range for the Automated Readability Index score.
      * @param score the ARI
     * @return String Age Range
     */
    public static String getAgeRange(double score) {
        switch ((int) Math.ceil(score)) {
            case 1:
                return "5-6";
            case 2:
                return "6-7";
            case 3:
                return "7-9";
            case 4:
                return "9-10";
            case 5:
                return "10-11";
            case 6:
                return "11-12";
            case 7:
                return "12-13";
            case 8:
                return "13-14";
            case 9:
                return "14-15";
            case 10:
                return "15-16";
            case 11:
                return "16-17";
            case 12:
                return "17-18";
            case 13:
                return "18-24";
            case 14:
                return "24+";
            default:
                return "";
        }
    }
}
