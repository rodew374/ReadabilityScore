package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program will scan text and output a readability score.
 * @version 3.0 Automated Readability Index. Reads a text file and calculates the ARI score.
 * score = 4.71 * characters/words + 0.5 * words/sentences - 21.43
 */
public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        File file = new File(arg[0]);
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        double score;
        int countW = 0;
        int countS = 0;
        int countC = 0;
        String ageRange = "";

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split("[.!?]+\\s*");
            countS += line.length;

            for (String sentence : line) {
                String[] words = sentence.split("\\s");
                countW += words.length;

                for (String word : words) {
                    countC += word.toCharArray().length;
                    sb.append(word).append(" ");
                }
            }
        }

        score = 4.71 * countC/countW + 0.5 * countW/countS - 21.43;

        switch ((int) Math.ceil(score)) {
            case 1:
                ageRange = "5-6";
                break;
            case 2:
                ageRange = "6-7";
                break;
            case 3:
                ageRange = "7-9";
                break;
            case 4:
                ageRange = "9-10";
                break;
            case 5:
                ageRange = "10-11";
                break;
            case 6:
                ageRange = "11-12";
                break;
            case 7:
                ageRange = "12-13";
                break;
            case 8:
                ageRange = "13-14";
                break;
            case 9:
                ageRange = "14-15";
                break;
            case 10:
                ageRange = "15-16";
                break;
            case 11:
                ageRange = "16-17";
                break;
            case 12:
                ageRange = "17-18";
                break;
            case 13:
                ageRange = "18-24";
                break;
            case 14:
                ageRange = "24+";
                break;
            default:
                break;
        }

        System.out.printf("The text is:\n%s\n\nWords: %d\nSentences: %d\nCharacters: %d\nThe score is: %,.2f\nThis text should be " +
                "understood" +
                " by %s-year-olds.", sb, countW, countS, countC, score, ageRange);
    }
}
