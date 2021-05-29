package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.ToDoubleBiFunction;

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

    Text(String fileName) throws IOException {
        text = new String(Files.readAllBytes(Paths.get(fileName)));
        characters = text.replaceAll("\\s", "").split("").length;
        words = text.split("\\s").length;
        sentences = text.split("[.?!]").length;

        countSyllables();
        calculateScores();

    }

    /**
     * TODO
     */
    private void countSyllables() {
        String data = text;
        data = data.replaceAll("e\\b", "");
        data = data.replaceAll("you", "a");
        data = data.replaceAll("[aeiouy]{2}", "a");
        data = data.replaceAll(" th ", " a ");
        data = data.replaceAll(",", "");
        data = data.replaceAll(" w ", " a ");
        data = data.replaceAll("[0-9]+", "a");
        data = data.replaceAll("[^aeiouy]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            String regex = "[^aiouy][aiouy]|e[a-zA-Z]";
            int count = 0;

            while (word.contains(regex)) {
                word = word.replaceFirst(regex, "");
                ++count;
            }

            syllables += count == 0 ? 1 : count;
            polySyllables += count > 2 ? 1 : 0;
        }
    }

    private void calculateScores() {
        ari = new ARI(this);
        fk = new FK(this);
        smog = new SMOG(this);
        cl = new CL(this);
    }

    void displayData() {
        System.out.printf("The text is:\n%s\n\nWords: %d\nSentences: %d\nCharacters: %d\nSyllables: %d\nPolysyllables: %d\n", text, words,
                            sentences, characters, syllables, polySyllables);
    }

    void displayScore(String input) {

        System.out.println();

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
                double avg = (ari.getAgeRange() + fk.getAgeRange() + smog.getAgeRange() + cl.getAgeRange()) / 4.0;

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
