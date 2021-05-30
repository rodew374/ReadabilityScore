package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This Text class stores data from a .txt file and calculates the number of words, sentences, characters, syllables and polySyllables.
 * Next it calculates and stores four different Readability Indices' scores.
 */
public class Text {
    final String text;
    final int words;
    final int sentences;
    final int characters;
    int syllables;
    int polySyllables;
    private Score ari;
    private Score fk;
    private Score smog;
    private Score cl;

    /**
     * Constructor for the Text Class. Reads a .txt file into a single String.
     * @param fileName The path to the .txt that will be used to calculate scores.
     * @throws IOException if file does not exist
     */
    Text(String fileName) throws IOException {
        text = new String(Files.readAllBytes(Paths.get(fileName)));
        characters = text.replaceAll("\\s", "").split("").length;
        words = text.split("\\s").length;
        sentences = text.split("[.?!]").length;

        countSyllables();
        calculateScores();

    }

    /**
     * Calculates the number of syllables and polySyllables in the .txt file.
     */
    private void countSyllables() {
        String data = text.toLowerCase();
        data = data.replaceAll("e\\b", "");
        data = data.replaceAll("you", "a");
        data = data.replaceAll("[aeiouy]{2}", "a");
        data = data.replaceAll(" th ", " a ");
        data = data.replaceAll(",", "");
        data = data.replaceAll(" w ", " a ");
        data = data.replaceAll("[0-9]+", "a");
        data = data.replaceAll("[^aeiouy\\s+]", "");

        String[] words = data.split("\\s+");

        for (String word : words) {
            syllables += word.length();
            polySyllables += word.length() > 2 ? 1 : 0;
        }
    }

    /**
     * Creates the four scores based on the .txt file.
     */
    private void calculateScores() {
        ari = new ARI(this);
        fk = new FK(this);
        smog = new SMOG(this);
        cl = new CL(this);
    }

    /**
     * Displays the statistics for the .txt file.
     */
    void displayData() {
        System.out.printf("The text is:\n%s\n\nWords: %d\nSentences: %d\nCharacters: %d\nSyllables: %d\nPolysyllables: %d\n", text, words,
                            sentences, characters, syllables, polySyllables);
    }

    /**
     * Displays the requested score(s) to the user.
     * @param input the requested score(s).
     */
    void displayScore(String input) {
        switch (input.toLowerCase()) {
            case "ari" :
                ari.display();
                break;
            case "fk" :
                fk.display();
                break;
            case "smog" :
                smog.display();
                break;
            case "cl" :
                cl.display();
                break;
            case "all" :
                double avg = (ari.getAge() + fk.getAge() + smog.getAge() + cl.getAge()) / 4.0;

                ari.display();
                fk.display();
                smog.display();
                cl.display();

                System.out.printf("\n\nThis text should be understood in average by %.2f-year-olds.", avg);
                break;
            default :
                break;
        }
    }
}
