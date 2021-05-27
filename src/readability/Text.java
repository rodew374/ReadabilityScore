package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Text {
    private final String text;
    final int words;
    final int sentences;
    final int characters;
    int syllables;
    int polySyllables;
    private Score ari;
    private Score fki;
    private Score smog;
    private Score cli;

    Text(String fileName) throws IOException {
        text = new String(Files.readAllBytes(Paths.get(fileName)));
        characters = text.replaceAll("\\s", "").split("").length;
        words = text.split("\\s").length;
        sentences = text.split("[.?!]").length;
    }

    void countSyllables() {
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

    void calculateScores() {
        ari = new ARI(this);
        fki = new FK(this);
        smog = new SMOG(this);
        cli = new CL(text);
    }
}
